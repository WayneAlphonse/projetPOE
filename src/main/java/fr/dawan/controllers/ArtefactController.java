package fr.dawan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import fr.dawan.DAO.InterfaceDao;
import fr.dawan.beans.Dodo;
import fr.dawan.beans.Jeux;
import fr.dawan.beans.Nourriture;

@Controller
public class ArtefactController {

	@Autowired
	@Qualifier("hibernateDao3")
	private InterfaceDao<Jeux> jeuDao;

	@Autowired
	@Qualifier("hibernateDao4")
	private InterfaceDao<Dodo> dodoDao;
	
	
	@Autowired
	@Qualifier("hibernateDao5")
	private InterfaceDao<Nourriture> nourritureDao;

	

	@PostMapping("/creajeux")
	public String createGame(Jeux jeux, Model model) {
		jeuDao.createOrUpdate(jeux);
		model.addAttribute("msg", "Jouet crée!");

		return "animaljoueur";
	}

	@PostMapping("/creadodo")
	public String createSleep(Dodo dodo, Model model) {
		dodoDao.createOrUpdate(dodo);
		model.addAttribute("msg", "Dodo crée!");

		return "animaljoueur";
	}

	@PostMapping("/creanourriture")
	public String createFood(Nourriture nourriture, Model model) {
		nourritureDao.createOrUpdate(nourriture);
		model.addAttribute("msg", "Nourriture crée!");

		return "animaljoueur";
	}

}
