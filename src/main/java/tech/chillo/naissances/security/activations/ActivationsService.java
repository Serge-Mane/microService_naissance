package tech.chillo.naissances.security.activations;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.chillo.naissances.profiles.Profile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;

@AllArgsConstructor
@Service
public class ActivationsService {
    private BCryptPasswordEncoder passwordEncoder;
    private ActivationsRepository activationsRepository;

    public Activation create(Profile profile) {
        Random random = new Random();
        int useCode = 100000 + random.nextInt(900000);
        Activation activation = Activation.builder()
                .active(Boolean.TRUE)
                .userCode(useCode)
                .code(passwordEncoder.encode(""+useCode))
                .creation(LocalDateTime.now())
                .desactivation(LocalDateTime.now().plusMinutes(5))
                .profile(profile)
                .build();
        return this.activationsRepository.save(activation);
    }

    public Profile validateAndReturnProfile(Map<String, String> parameters) {
        List<Activation> activations = this.activationsRepository
                .findAllByActiveAndDesactivationAfter(
                            true,
                            LocalDateTime.now()
                    );
        activations = activations.stream().filter(
                activation -> passwordEncoder.matches(
                        parameters.get("code"),
                        activation.getCode()
                )).toList();
        if (activations.isEmpty()) {
            throw new RuntimeException("Le code est invalide ou il a expiré");
        }

        Activation activation = activations.getFirst();
        activation.setActive(Boolean.FALSE);
        this.activationsRepository.save(activation);
        return activation.getProfile();
    }
}
