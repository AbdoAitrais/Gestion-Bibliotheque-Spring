package ma.fstm.ilisi2.gestionbiblio.model.services;


import jakarta.transaction.Transactional;
import ma.fstm.ilisi2.gestionbiblio.model.bo.Exemplaire;
import ma.fstm.ilisi2.gestionbiblio.model.bo.Livre;
import ma.fstm.ilisi2.gestionbiblio.model.dao.ExemplaireRepository;
import ma.fstm.ilisi2.gestionbiblio.model.dao.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LivreService {

    @Autowired
    private LivreRepository repoLivre;
    @Autowired
    private ExemplaireRepository repoExamplaire;

    public List<Livre> listAll(){
        return repoLivre.findAll();
    }

    public void save(Livre livre){
        repoLivre.save(livre);
    }

    public void save(Livre livre,long examplaires){
        repoLivre.save(livre);
        for (long i = 0; i < examplaires; i++) {
            repoExamplaire.save(new Exemplaire(livre,true));
        }
    }

    public void delete(long id){
        repoLivre.deleteById(id);
    }

    public Optional<Livre> get(long id){
        return repoLivre.findById(id);
    }

}
