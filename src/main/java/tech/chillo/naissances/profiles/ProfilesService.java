package tech.chillo.naissances.profiles;


import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.chillo.naissances.shared.services.ValidationsService;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class ProfilesService {
    private final ProfilesRepository profilesRepository;
    private final ValidationsService validationsService;

    public void create(Profile profile) {
        log.info("Nouveau compte avec l'email {}", profile.getEmail() );
        this.validationsService.validateEmail(profile.getEmail());
        this.validationsService.validatePhone(profile.getPhone());
        this.profilesRepository.save(profile);

    }

    public List<Profile> search() {
        return this.profilesRepository.findAll();
    }

    public Profile read(int id) {
        Optional<Profile> profileOptional = this.profilesRepository.findById(id);
        return profileOptional.orElseThrow(() -> new EntityNotFoundException(
                "Aucune entité ne correspond aux paramètres fournis"));
    }

    public Profile update(int id, Profile profile) {
        Profile profileInDatabase = this.read(id);

        profileInDatabase.setFirstName(profile.getFirstName());
        profileInDatabase.setLastName(profile.getLastName());
        profileInDatabase.setEmail(profile.getEmail());
        profileInDatabase.setPhone(profile.getPhone());

        profileInDatabase = this.profilesRepository.save(profileInDatabase);
        return profileInDatabase;
    }

    public void delete(int id) {
        Profile profile = this.read(id);
        this.profilesRepository.delete(profile);
    }
}
