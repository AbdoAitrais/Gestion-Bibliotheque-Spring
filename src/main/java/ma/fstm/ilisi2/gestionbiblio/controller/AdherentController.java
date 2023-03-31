package ma.fstm.ilisi2.gestionbiblio.controller;

import ma.fstm.ilisi2.gestionbiblio.model.bo.Adherent;
import ma.fstm.ilisi2.gestionbiblio.model.services.AdherentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class AdherentController {

    @Autowired
    private AdherentService adherentService;

    @RequestMapping("/adherent")
    public String viewHomePage(Model model){
        List<Adherent> listAdherents = adherentService.listAll();
        model.addAttribute("listAdherents",listAdherents);

        return "adherent";
    }

    @RequestMapping("/newAdherent")
    public String showNewAdherentPage(Model model){
        Adherent adherent = new Adherent();
        model.addAttribute("adherent",adherent);

        return "new_adherent";
    }

    @RequestMapping(value = "/saveAdherent", method = RequestMethod.POST)
    public String saveAdherent(@ModelAttribute("adherent") Adherent adherent){
        adherentService.save(adherent);

        return "redirect:/adherent";
    }

    @RequestMapping("/editAdherent/{id}")
    public ModelAndView showEditAdherentPage(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_adherent");
        Optional<Adherent> adherent = adherentService.get(id);
        mav.addObject("adherent",adherent);

        return mav;
    }

    @RequestMapping("/deleteAdherent/{id}")
    public String deleteAdherent(@PathVariable(name = "id") int id) {
        adherentService.delete(id);
        return "redirect:/adherent";
    }

}
