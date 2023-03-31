package ma.fstm.ilisi2.gestionbiblio.model.services;


import jakarta.transaction.Transactional;
import ma.fstm.ilisi2.gestionbiblio.model.bo.Adherent;
import ma.fstm.ilisi2.gestionbiblio.model.bo.Emprunt;
import ma.fstm.ilisi2.gestionbiblio.model.dao.AdherentRepository;
import ma.fstm.ilisi2.gestionbiblio.model.dao.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmpruntService {
    @Autowired
    private EmpruntRepository repo;

    public List<Emprunt> listAll(){
        return repo.findAll();
    }

    public void save(Emprunt emprunt){
        repo.save(emprunt);
    }

    public void delete(long id){
        repo.deleteById(id);
    }

    public Optional<Emprunt> get(long id){
        return repo.findById(id);
    }
}
