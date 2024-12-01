package tech.chillo.naissances.authentification;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.chillo.naissances.notifications.EmailsService;
import tech.chillo.naissances.profiles.*;
import tech.chillo.naissances.security.activations.Activation;
import tech.chillo.naissances.security.activations.ActivationsService;
import tech.chillo.naissances.shared.services.ValidationsService;

import java.util.Map;

@Slf4j
@AllArgsConstructor
@Service
public class AuthentificationService implements UserDetailsService {
    private final ProfilesMapper profilesMapper;
    private final ProfilesRepository profilesRepository;
    private final RolesRepository rolesRepository;
    private final EmailsService emailsService;
    private final ActivationsService activationsService;
    private final ValidationsService validationsService;
    private final BCryptPasswordEncoder passwordEncoder;

    public void create(ProfileDTO profileDTO) {
        log.info("Nouveau compte avec l'email {}", profileDTO.getEmail() );
        Profile profile = this.profilesMapper.dtoToEntity(profileDTO);

        String userPassword = profile.getPassword();
        String encodedPassword =  this.passwordEncoder.encode(userPassword);
        profile.setPassword(encodedPassword);

        Role role = this.rolesRepository.findByName("PUBLIC");
        profile.setRole(role);

        this.validationsService.validateEmail(profile.getEmail());
        this.validationsService.validatePhone(profile.getPhone());
        profile = this.profilesRepository.save(profile);
        Activation activation = this.activationsService.create(profile);
        log.info("le code d'activation pour {} est {}", profile.getEmail(), activation.getUserCode());
        this.emailsService.send(
                Map.of(
                        "email", profile.getEmail(),
                        "name", String.format("%s %s", profile.getFirstName(), profile.getLastName()),
                        "code", "" + activation.getUserCode(),
                        "template", "activation-code.ftl"
                )
        );

    }

    public void activate(Map<String, String> parameters) {
        Profile profile = this.activationsService.validateAndReturnProfile(parameters);
        profile.setActive(true);
        this.profilesRepository.save(profile);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.profilesRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("Aucun utilisateur ne corresonds aux critères saisis"));
    }
}
