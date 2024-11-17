package tech.chillo.naissances.authentification;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.chillo.naissances.profiles.*;
import tech.chillo.naissances.shared.services.ValidationsService;

@Slf4j
@AllArgsConstructor
@Service
public class AuthentificationService {
    private ProfileMapper profileMapper;
    private ProfilesRepository profilesRepository;
    private RolesRepository rolesRepository;
    private final ValidationsService validationsService;
    private final BCryptPasswordEncoder passwordEncoder;

    public void create(ProfileDTO profileDTO) {
        log.info("Nouveau compte avec l'email {}", profileDTO.email() );
        Profile profile = this.profileMapper.dtoToEntity(profileDTO);

        String userPassword = profile.getPassword();
        String encodedPassword =  this.passwordEncoder.encode(userPassword);
        profile.setPassword(encodedPassword);

        Role role = this.rolesRepository.findByName("PUBLIC");
        profile.setRole(role);

        this.validationsService.validateEmail(profile.getEmail());
        this.validationsService.validatePhone(profile.getPhone());
        this.profilesRepository.save(profile);

    }
}
