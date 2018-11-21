package fr.dawan.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.DAO.InterfaceAnimalDao;
import fr.dawan.DAO.InterfaceJoueurDao;
import fr.dawan.beans.Animal;
import fr.dawan.beans.Joueur;
import fr.dawan.beans.TypeAnimal;

@Controller
public class ChoiceController {

	@Autowired
	@Qualifier("hibernateDao2")
	private InterfaceAnimalDao<Animal> daoAnimal;
	@Autowired
	@Qualifier("hibernateDao")
	private InterfaceJoueurDao<Joueur> daoJoueur;

	@PostMapping(value = "/choice")
	public String redirectListAnimal(Model model, @RequestParam("typeAnimal") TypeAnimal typeAnimal) {

		model.addAttribute("listeAnimals", daoAnimal.findByEnum(typeAnimal));

		return "listeanimal";
	}

	@PostMapping("/animaljoueur")
	public String redirectPlayerAnimal(Model model, @RequestParam("id") int id, HttpSession session) {
		Animal animal = daoAnimal.findById(id);
		model.addAttribute("animal", animal);
		Object joueurObj = session.getAttribute("joueur");

		if (joueurObj != null) {
			Joueur joueur = (Joueur) joueurObj;
			joueur.setAnimal(animal);
			daoJoueur.createOrUpdate(joueur);
		}

		return "animaljoueur";
	}
}
