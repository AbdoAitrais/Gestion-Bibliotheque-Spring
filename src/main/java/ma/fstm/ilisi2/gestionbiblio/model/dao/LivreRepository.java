package ma.fstm.ilisi2.gestionbiblio.model.dao;

import ma.fstm.ilisi2.gestionbiblio.model.bo.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre,Long> {

}
