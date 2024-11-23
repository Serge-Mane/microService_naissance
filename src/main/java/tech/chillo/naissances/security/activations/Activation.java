package tech.chillo.naissances.security.activations;

import jakarta.persistence.*;
import lombok.*;
import tech.chillo.naissances.profiles.Profile;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "activations")
public class Activation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Transient
    private int userCode;
    private String code;
    private boolean active;
    private LocalDateTime creation;
    private LocalDateTime desactivation;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "profiles_id")
    private Profile profile;

}
