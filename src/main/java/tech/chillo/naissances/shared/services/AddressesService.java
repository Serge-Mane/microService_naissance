package tech.chillo.naissances.shared.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.chillo.naissances.shared.entities.Address;

@AllArgsConstructor
@Component
public class AddressesService {
    private final AddressesRepository addressesRepository;
    public Address create(Address address) {
        return this.addressesRepository.save(address);
    }
}
