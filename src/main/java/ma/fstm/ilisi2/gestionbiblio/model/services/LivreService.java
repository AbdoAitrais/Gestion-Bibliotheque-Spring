package ma.fstm.ilisi2.gestionbiblio.model.services;


import jakarta.transaction.Transactional;
import ma.fstm.ilisi2.gestionbiblio.model.bo.Livre;
import ma.fstm.ilisi2.gestionbiblio.model.dao.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LivreService {

    @Autowired
    private LivreRepository repo;

    public List<Livre> listAll(){
        return repo.findAll();
    }

    public void save(Livre livre){
        repo.save(livre);
    }

    public void delete(long id){
        repo.deleteById(id);
    }

    public Optional<Livre> get(long id){
        return repo.findById(id);
    }

}
