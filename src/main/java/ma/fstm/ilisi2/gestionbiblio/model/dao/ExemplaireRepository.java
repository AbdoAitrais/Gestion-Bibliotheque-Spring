package ma.fstm.ilisi2.gestionbiblio.model.dao;

import ma.fstm.ilisi2.gestionbiblio.model.bo.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplaireRepository extends JpaRepository<Exemplaire,Long> {

}
