package fr.dawan.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.DAO.InterfaceDao;
import fr.dawan.DAO.InterfaceDodoDao;
import fr.dawan.DAO.InterfaceJeuxDao;
import fr.dawan.beans.Animal;
import fr.dawan.beans.Dodo;
import fr.dawan.beans.Jeux;
import fr.dawan.beans.Joueur;
import fr.dawan.beans.Nourriture;

@Controller
public class CalculController {
	@Autowired
	@Qualifier("hibernateDao3")
	private InterfaceJeuxDao<Jeux> jeuDao;

	@Autowired
	@Qualifier("hibernateDao4")
	private InterfaceDodoDao<Dodo> dodoDao;

	@Autowired
	@Qualifier("hibernateDao5")
	private InterfaceDao<Nourriture> nourritureDao;
	
	@PostMapping("/calculjeu")
	public String calculPlay(Model model, HttpSession session, @RequestParam("typeJeux") String typeJeux,
			@RequestParam("dureeJeux") Integer dureeJeux) {
		Jeux jeux = jeuDao.findByTypeJeux(typeJeux);
		Object joueurSession = session.getAttribute("joueur");
		if (joueurSession != null) {
			Joueur joueur = (Joueur) joueurSession;
			model.addAttribute("animal", joueur.getAnimal());

			int resultTauxJeux = jeux.getTauxBonheur() * dureeJeux;
			if (resultTauxJeux >= (joueur.getAnimal().getSportif())) {

				model.addAttribute("msg", (joueur.getAnimal().getNom()) + " est très heureux d'avoir joué avec toi !");
			} else {

				model.addAttribute("msg1", (joueur.getAnimal().getNom()) + " aimerait jouer encore avec toi !");
			}

			model.addAttribute("listeJeux", jeuDao.findAll());
			model.addAttribute("listeDodo", dodoDao.findAll());
			model.addAttribute("listeNourriture", nourritureDao.findAll());
		}
		return "animaljoueur";
	}

	@PostMapping("/calculdodo")
	public String calculSleep(Model model, HttpSession session, @RequestParam("lieu") String lieu,
			@RequestParam("dureeDodo") Integer dureeDodo) {

		Dodo dodo = dodoDao.findByLieu(lieu);
		Object joueurSession = session.getAttribute("joueur");
		if (joueurSession != null) {
			Joueur joueur = (Joueur) joueurSession;

			model.addAttribute("animal", joueur.getAnimal());

			Animal animal = joueur.getAnimal();
		
			int dodoresultat = dureeDodo * dodo.getTauxSommeil();

			if (dodoresultat >= animal.getMarmotte()) {
				model.addAttribute("msg", animal.getNom() + "a bien dormi et en forme pour la journée!");

			}

			else {
				model.addAttribute("msg", animal.getNom() + "est encore fatigué...");
			}
			model.addAttribute("listeJeux", jeuDao.findAll());
			model.addAttribute("listeDodo", dodoDao.findAll());
			model.addAttribute("listeNourriture", nourritureDao.findAll());
		}

		return "animaljoueur";

	}

}
