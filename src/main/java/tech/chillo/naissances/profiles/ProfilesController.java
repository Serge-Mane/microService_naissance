package tech.chillo.naissances.profiles;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Profile profile) {
        log.info("Création du compte {} ", profile.getEmail());
        this.profilesService.create(profile);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Profile> search() {
        return this.profilesService.search();
    }

    @GetMapping(path = "{id}")
    public Profile read(@PathVariable int id) {
        return this.profilesService.read(id);
    }

    @PutMapping(path = "{id}")
    public Profile update(@PathVariable int id, @RequestBody Profile profile) {
        return this.profilesService.update(id, profile);
    }

}
