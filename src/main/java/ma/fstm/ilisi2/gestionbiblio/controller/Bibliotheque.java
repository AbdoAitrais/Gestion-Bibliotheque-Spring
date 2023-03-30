package ma.fstm.ilisi2.gestionbiblio.controller;


import ma.fstm.ilisi2.gestionbiblio.model.bo.Livre;
import ma.fstm.ilisi2.gestionbiblio.model.services.LivreService;
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
public class Bibliotheque {

    /// Injects the service on execution
    @Autowired
    private LivreService livreService;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Livre> listLivres = livreService.listAll();
        model.addAttribute("bookList",listLivres);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewLivrePage(Model model){
        Livre livre = new Livre();
        model.addAttribute("book",livre);

        return "new_livre";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveLivre(@ModelAttribute("book") Livre livre){
        livreService.save(livre);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditLivrePage(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_livre");
        Optional<Livre> livre = livreService.get(id);
        mav.addObject("book",livre);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        livreService.delete(id);
        return "redirect:/";
    }

}
