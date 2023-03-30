package ma.fstm.ilisi2.gestionbiblio.model.services;

import jakarta.transaction.Transactional;
import ma.fstm.ilisi2.gestionbiblio.model.bo.Adherent;
import ma.fstm.ilisi2.gestionbiblio.model.bo.Exemplaire;
import ma.fstm.ilisi2.gestionbiblio.model.dao.ExemplaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExemplaireService {
    ExemplaireRepository repo;
    public List<Exemplaire> listAll(){
        return repo.findAll();
    }

    public void save(Exemplaire exemplaire){
        repo.save(exemplaire);
    }

    public void delete(long id){
        repo.deleteById(id);
    }

    public Optional<Exemplaire> get(long id){
        return repo.findById(id);
    }
}
