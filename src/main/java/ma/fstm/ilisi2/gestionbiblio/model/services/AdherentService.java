package ma.fstm.ilisi2.gestionbiblio.model.services;

import jakarta.transaction.Transactional;
import ma.fstm.ilisi2.gestionbiblio.model.bo.Adherent;
import ma.fstm.ilisi2.gestionbiblio.model.dao.AdherentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdherentService {

    @Autowired
    private AdherentRepository repo;

    public List<Adherent> listAll(){
        return repo.findAll();
    }

    public void save(Adherent adherent){
        repo.save(adherent);
    }

    public void delete(long id){
        repo.deleteById(id);
    }

    public Optional<Adherent> get(long id){
        return repo.findById(id);
    }

}
