package tech.chillo.naissances.authentification;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.chillo.naissances.profiles.Profile;
import tech.chillo.naissances.profiles.ProfileDTO;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RequestMapping(consumes = APPLICATION_JSON_VALUE)
@RestController
public class AuthentificationController {

    private AuthentificationService authentificationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "sign-up")
    public void create(@RequestBody ProfileDTO profileDTO) {
        this.authentificationService.create(profileDTO);
    }
}
