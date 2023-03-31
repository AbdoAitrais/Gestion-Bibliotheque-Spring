package ma.fstm.ilisi2.gestionbiblio.controller;


import ma.fstm.ilisi2.gestionbiblio.model.bo.Adherent;
import ma.fstm.ilisi2.gestionbiblio.model.bo.Emprunt;
import ma.fstm.ilisi2.gestionbiblio.model.bo.Emprunt;
import ma.fstm.ilisi2.gestionbiblio.model.bo.Exemplaire;
import ma.fstm.ilisi2.gestionbiblio.model.services.AdherentService;
import ma.fstm.ilisi2.gestionbiblio.model.services.EmpruntService;
import ma.fstm.ilisi2.gestionbiblio.model.services.EmpruntService;
import ma.fstm.ilisi2.gestionbiblio.model.services.ExemplaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class EmpruntController {
    @Autowired
    private EmpruntService empruntService;
    @Autowired
    private AdherentService adherentService;
    @Autowired
    private ExemplaireService exemplaireService;

    @RequestMapping("/emprunt")
    public String viewHomePage(Model model){
        List<Emprunt> empruntList = empruntService.listAll();
        model.addAttribute("empruntList",empruntList);

        return "emprunt";
    }

    @RequestMapping("/newEmprunt")
    public String showNewEmpruntPage(Model model){
        Emprunt emprunt = new Emprunt();
        model.addAttribute("emprunt",emprunt);
        model.addAttribute("examples",exemplaireService.listAll());
        model.addAttribute("adherents",adherentService.listAll());
        return "new_emprunt";
    }

    @RequestMapping(value = "/saveEmprunt", method = RequestMethod.POST)
    public String saveEmprunt(@ModelAttribute("emprunt") Emprunt emprunt,
                              @RequestParam("idExample") long idExample,
                              @RequestParam("idAdherent") long idAdherent,
                              @RequestParam("dateRetourStr") String dateRetourStr){
        Exemplaire exemplaire = exemplaireService.get(idExample).get();
        emprunt.setExemplaire(exemplaire);
        emprunt.setAdherent(adherentService.get(idAdherent).get());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateRetour = LocalDate.parse(dateRetourStr, formatter);

        emprunt.setDateEmprunt(new java.sql.Date(new Date().getTime()));
        emprunt.setDateRetour(new java.sql.Date(Date.from(dateRetour.atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime()));

        exemplaire.setDisponible(false);
        exemplaireService.save(exemplaire);
        empruntService.save(emprunt);

        return "redirect:/emprunt";
    }


    @RequestMapping("/editEmprunt/{id}")
    public ModelAndView showEditEmpruntPage(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_emprunt");
        Optional<Emprunt> emprunt = empruntService.get(id);
        mav.addObject("emprunt",emprunt);

        return mav;
    }

    @RequestMapping("/deleteEmprunt/{id}")
    public String deleteEmprunt(@PathVariable(name = "id") int id) {
        empruntService.delete(id);
        return "redirect:/emprunt";
    }
}
