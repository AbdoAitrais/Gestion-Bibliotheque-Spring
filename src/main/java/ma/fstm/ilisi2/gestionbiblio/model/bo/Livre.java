package ma.fstm.ilisi2.gestionbiblio.model.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Livres")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String isbn;
    @Column(nullable = false)
    private String titre;
    private String auteur;
    @OneToMany(mappedBy = "livre", fetch = FetchType.EAGER)
    private Set<Exemplaire> exemplaires;
}
