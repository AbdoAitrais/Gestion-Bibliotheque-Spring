package ma.fstm.ilisi2.gestionbiblio.controller;


import ma.fstm.ilisi2.gestionbiblio.model.bo.Livre;
import ma.fstm.ilisi2.gestionbiblio.model.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class LivreController {
    @Autowired
    private LivreService livreService;

    @RequestMapping("/livre")
    public String viewHomePage(Model model){
        List<Livre> listLivres = livreService.listAll();
        model.addAttribute("bookList",listLivres);

        return "livre";
    }

    @RequestMapping("/new")
    public String showNewLivrePage(Model model){
        Livre livre = new Livre();
        model.addAttribute("book",livre);
        return "new_livre";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveLivre(@ModelAttribute("book") Livre livre, @RequestParam("nbrExamples") long nbrExamples){
        livreService.save(livre,  nbrExamples);
        return "redirect:/livre";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateLivre(@ModelAttribute("book") Livre livre){
        livreService.save(livre);
        return "redirect:/livre";
    }


    @RequestMapping("/edit/{id}")
    public ModelAndView showEditLivrePage(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_livre");
        Optional<Livre> livre = livreService.get(id);
        mav.addObject("book",livre);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteLivre(@PathVariable(name = "id") int id) {
        livreService.delete(id);
        return "redirect:/livre";
    }

}
