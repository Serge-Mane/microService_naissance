package tech.chillo.naissances.shared.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.chillo.naissances.shared.entities.Company;
import tech.chillo.naissances.shared.repositories.CompaniesRepository;

import java.util.Optional;

@AllArgsConstructor
@Component
public class CompaniesService {
    private CompaniesRepository companiesRepository;

    public Company createIfNotExist(Company company) {
        Optional<Company> optionalCompany = this.companiesRepository.findByName(company.getName());
        if(optionalCompany.isEmpty()) {
            company = this.companiesRepository.save(company);
        } else {
            company = optionalCompany.get();
        }
        return company;
    }
}
