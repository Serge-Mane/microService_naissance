package tech.chillo.naissances.shared.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.chillo.naissances.shared.entities.Company;
import tech.chillo.naissances.shared.entities.Status;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Integer> {
    Optional<Status> findByName(String name);
}
