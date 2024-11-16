package tech.chillo.naissances.profiles;


import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class ProfilesService {
    private final ProfilesRepository profilesRepository;
    private final ProfileMapper profileMapper;

    public Set<ProfileDTO> search() {

        List<Profile> profiles = this.profilesRepository.findAll();
        return profiles.stream().map(this.profileMapper::entityToDto).collect(Collectors.toSet());
    }

    public Profile read(int id) {
        Optional<Profile> profileOptional = this.profilesRepository.findById(id);
        return profileOptional.orElseThrow(() -> new EntityNotFoundException("Aucune entité ne correspond aux paramètres fournis"));
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
