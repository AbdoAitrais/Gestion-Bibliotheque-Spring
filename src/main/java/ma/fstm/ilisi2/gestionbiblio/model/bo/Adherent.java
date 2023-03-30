package ma.fstm.ilisi2.gestionbiblio.model.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Adherents")
public class Adherent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String prenomAdherent;
    private String nomAdherent;

    @OneToMany(mappedBy = "adherent", fetch = FetchType.LAZY)
    private Set<Emprunt> empruntsByid;
}
