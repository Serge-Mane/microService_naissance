package tech.chillo.naissances.profiles;


import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class ProfilesService {
    private final ProfilesRepository profilesRepository;

    public void create(Profile profile) {

        log.info("Nouveau compte avec l'email {}", profile.getEmail() );
        this.profilesRepository.save(profile);

    }
}
