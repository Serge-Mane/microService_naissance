package tech.chillo.naissances.declarations;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.chillo.naissances.profiles.Profile;
import tech.chillo.naissances.profiles.ProfileDTO;
import tech.chillo.naissances.shared.entities.Company;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class DeclarationDTO {
    private int id;
    private String name;
    private String description;
    private String comment;
    private LocalDateTime registered;
    private ProfileDTO firstParent;

    private ProfileDTO secondParent;
    private ProfileDTO child;
    private Company company;
    private List<DeclarationStatus> statuses;
}
