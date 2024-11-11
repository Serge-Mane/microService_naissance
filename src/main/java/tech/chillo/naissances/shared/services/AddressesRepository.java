package tech.chillo.naissances.shared.services;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.chillo.naissances.shared.entities.Address;

public interface AddressesRepository extends JpaRepository<Address, Integer> {
}
