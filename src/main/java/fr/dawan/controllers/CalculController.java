package fr.dawan.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.DAO.InterfaceJeuxDao;

import fr.dawan.beans.Jeux;
import fr.dawan.beans.Joueur;

@Controller
public class CalculController {
	@Autowired
	@Qualifier("hibernateDao3")
	private InterfaceJeuxDao<Jeux> jeuDao;

	@PostMapping("/calculjeu")
	public String calculPlay(Model model, HttpSession session, @RequestParam("typeJeux") String typeJeux,
			@RequestParam("dureeJeux") Integer dureeJeux) {
		Jeux jeux = jeuDao.findByTypeJeux(typeJeux);
		Object joueurSession = session.getAttribute("joueur");
		if (joueurSession != null) {
			Joueur joueur = (Joueur) joueurSession;
			 model.addAttribute("animal", joueur.getAnimal());

			int resultTauxJeux = jeux.getTauxBonheur() * dureeJeux;
			if (resultTauxJeux >= (joueur.getAnimal().getSportif())){

				model.addAttribute("msg", (joueur.getAnimal().getNom()) + " est très heureux d'avoir joué avec toi !");
			} else {

				model.addAttribute("msg1", (joueur.getAnimal().getNom()) + " aimerait jouer encore avec toi !");
			}
		}
		return "animaljoueur";
	}
}
