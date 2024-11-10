package tech.chillo.naissances.profiles;


import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class ProfilesService {
    private final ProfilesRepository profilesRepository;

    public void create(Profile profile) {
        log.info("Nouveau compte avec l'email {}", profile.getEmail() );
        this.profilesRepository.save(profile);

    }

    public List<Profile> search() {
        return this.profilesRepository.findAll();
    }

    public Profile read(int id) {
        Optional<Profile> profileOptional = this.profilesRepository.findById(id);
        return profileOptional.orElse(null);
    }
}
