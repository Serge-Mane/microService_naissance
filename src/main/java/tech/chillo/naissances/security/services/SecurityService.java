package tech.chillo.naissances.security.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import tech.chillo.naissances.profiles.Profile;
import tech.chillo.naissances.profiles.ProfilesRepository;

import java.util.Optional;

@AllArgsConstructor
@Component
public class SecurityService {
    private ProfilesRepository profilesRepository;
    public Profile getCurrentUser() {
       Jwt jwt = (Jwt) SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal();

       String email = jwt.getSubject();
       Optional<Profile> profileOptional = this.profilesRepository.findByEmail(email);
       return profileOptional.orElseThrow(() -> new EntityNotFoundException("Aucune entité ne correspond aux paramètres fournis"));
    }
}
