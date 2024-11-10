package tech.chillo.naissances.profiles;


import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ProfilesService {

    Logger logger = LoggerFactory.getLogger(ProfilesService.class);
    public void create(Profile profile) {

        logger.info("Nouveau compte avec l'email {}", profile.getEmail() );

    }
}
