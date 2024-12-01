package tech.chillo.naissances.shared.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.chillo.naissances.shared.entities.Company;

import java.util.Optional;

public interface CompaniesRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findByName(String name);
}
