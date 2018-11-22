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
import fr.dawan.DAO.InterfaceNourritureDao;
import fr.dawan.beans.Animal;
import fr.dawan.beans.Dodo;
import fr.dawan.beans.Jeux;
import fr.dawan.beans.Joueur;
import fr.dawan.beans.Nourriture;
import fr.dawan.utils.Constantes;

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
	private InterfaceNourritureDao<Nourriture> nourritureDao;

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

				model.addAttribute("msg", (joueur.getAnimal().getNom()) + Constantes.HAPPY_PLAYER);
			} else {

				model.addAttribute("msg", (joueur.getAnimal().getNom()) + Constantes.SAD_PLAYER);
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
				model.addAttribute("msg", animal.getNom() + Constantes.HAPPY_SLEEPER);

			}

			else {
				model.addAttribute("msg", animal.getNom() + Constantes.SAD_SLEEPER);
			}
			model.addAttribute("listeJeux", jeuDao.findAll());
			model.addAttribute("listeDodo", dodoDao.findAll());
			model.addAttribute("listeNourriture", nourritureDao.findAll());
		}

		return "animaljoueur";

	}

	@PostMapping("/calculnourriture")
	public String calculFood(@RequestParam("quantiteNourriture") Integer quantiteNourriture, Model model,
			@RequestParam("typeNourriture") String typeNourriture, HttpSession session) {
		Nourriture nourriture = nourritureDao.findByTypeNourriture(typeNourriture);
		Object joueurSession = session.getAttribute("joueur");
		if (joueurSession != null) {
			Joueur joueur = (Joueur) joueurSession;
			Animal animal = joueur.getAnimal();
			model.addAttribute("animal", animal);

			int nourritureResultat = quantiteNourriture * nourriture.getTauxSatiete();
			if (nourritureResultat >= animal.getGourmand()) {
				model.addAttribute("msg", animal.getNom() + Constantes.HAPPY_EATER);
			} else {
				model.addAttribute("msg", animal.getNom() + Constantes.SAD_EATER);
			}
			model.addAttribute("listeJeux", jeuDao.findAll());
			model.addAttribute("listeDodo", dodoDao.findAll());
			model.addAttribute("listeNourriture", nourritureDao.findAll());

		}

		return "animaljoueur";

	}

}
