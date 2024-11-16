package tech.chillo.naissances.authentification;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.chillo.naissances.profiles.Profile;
import tech.chillo.naissances.profiles.ProfileDTO;
import tech.chillo.naissances.profiles.ProfileMapper;
import tech.chillo.naissances.profiles.ProfilesRepository;
import tech.chillo.naissances.shared.services.ValidationsService;

@Slf4j
@AllArgsConstructor
@Service
public class AuthentificationService {
    private ProfileMapper profileMapper;
    private ProfilesRepository profilesRepository;
    private final ValidationsService validationsService;
    private final BCryptPasswordEncoder passwordEncoder;

    public void create(ProfileDTO profileDTO) {
        log.info("Nouveau compte avec l'email {}", profileDTO.email() );
        Profile profile = this.profileMapper.dtoToEntity(profileDTO);

        String userPassword = profile.getPassword();
        String encodedPassword =  this.passwordEncoder.encode(userPassword);
        profile.setPassword(encodedPassword);

        this.validationsService.validateEmail(profile.getEmail());
        this.validationsService.validatePhone(profile.getPhone());
        this.profilesRepository.save(profile);

    }
}
