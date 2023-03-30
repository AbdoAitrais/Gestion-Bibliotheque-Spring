package ma.fstm.ilisi2.gestionbiblio.model.bo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Exemplaires")
public class Exemplaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private boolean disponible;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_livre")
    private Livre livre;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exemplaire")
    @ToString.Exclude
    private Set<Emprunt> emprunts;


    public Exemplaire(Livre livre, boolean disponible) {
        this.livre = livre;
        this.disponible = disponible;
    }
}
