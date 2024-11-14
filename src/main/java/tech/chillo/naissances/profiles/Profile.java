package tech.chillo.naissances.profiles;

import jakarta.persistence.*;
import lombok.*;
import tech.chillo.naissances.shared.entities.Address;
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Civility civility;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "addresses_id")
    private Address address;
}
