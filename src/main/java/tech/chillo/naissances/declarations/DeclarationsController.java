package tech.chillo.naissances.declarations;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping("declarations")
public class DeclarationsController {

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Declaration> search() {
        return new ArrayList<>();
    }
}
