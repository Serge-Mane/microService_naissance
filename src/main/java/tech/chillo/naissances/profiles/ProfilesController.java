package tech.chillo.naissances.profiles;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
    Controlleur pour gérer les opérations
    sur les profiles
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("profiles")
public class ProfilesController {

    private final ProfilesService profilesService;

    @PostMapping
    public void create(@RequestBody Profile profile) {
        log.info("Création du compte {} ", profile.getEmail());
        this.profilesService.create(profile);
    }

}
