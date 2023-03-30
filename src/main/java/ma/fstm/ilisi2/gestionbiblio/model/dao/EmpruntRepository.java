package ma.fstm.ilisi2.gestionbiblio.model.dao;

import ma.fstm.ilisi2.gestionbiblio.model.bo.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<Emprunt,Long> {

}
