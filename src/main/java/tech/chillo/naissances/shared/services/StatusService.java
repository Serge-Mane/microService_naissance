package tech.chillo.naissances.shared.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.chillo.naissances.shared.entities.Status;
import tech.chillo.naissances.shared.repositories.StatusRepository;

import java.util.Map;

@AllArgsConstructor
@Component
public class StatusService {
    private StatusRepository statusRepository;

    public Status search(Map<String, Object> parameters) {
        String name = (String) parameters.get("name");

        return this.statusRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Statut inconnu"));
    }
}
