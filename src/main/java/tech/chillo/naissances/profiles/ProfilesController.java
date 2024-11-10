package tech.chillo.naissances.profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @PostMapping
    public void create(@RequestBody Profile profile) {
        logger.trace("Création du compte " + profile.getEmail());
        logger.debug("Création du compte " + profile.getEmail());
        logger.info("Création du compte " + profile.getEmail());
        logger.warn("Création du compte " + profile.getEmail());
        logger.error("Création du compte " + profile.getEmail());
    }

}
