package tech.chillo.naissances.profiles;

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
@RestController
@RequestMapping("profiles")
public class ProfilesController {

    Logger logger = LoggerFactory.getLogger(ProfilesController.class);

    private final ProfilesService profilesService;

    public ProfilesController(ProfilesService profilesService) {
        this.profilesService = profilesService;
    }

    @PostMapping
    public void create(@RequestBody Profile profile) {
        logger.info("Création du compte " + profile.getEmail());
        this.profilesService.create(profile);
    }

}
