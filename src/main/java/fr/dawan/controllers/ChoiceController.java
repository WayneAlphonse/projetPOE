package fr.dawan.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.DAO.InterfaceAnimalDao;
import fr.dawan.DAO.InterfaceDao;
import fr.dawan.DAO.InterfaceJoueurDao;
import fr.dawan.beans.Animal;
import fr.dawan.beans.Jeux;
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
	@Autowired
	@Qualifier("hibernateDao3")
	private InterfaceDao<Jeux> jeuxDao;

	@PostMapping(value = "/choice")
	public String redirectListAnimal(Model model, @RequestParam("typeAnimal") TypeAnimal typeAnimal) {

		model.addAttribute("listeAnimals", daoAnimal.findByEnum(typeAnimal));

		return "listeanimal";
	}

	@PostMapping("/animaljoueur")
	public String redirectPlayerAnimal(Model model, @RequestParam("id") int id, HttpSession session) {
		//avec l'id récuperée depuis la page précedente, on retrouve l'animal correspondant
		Animal animal = daoAnimal.findById(id);
		//on le met dans un model afin de pouvoir afficher les attributs de mon objet dans ma page jsp
		model.addAttribute("animal", animal);
		//depuis la session on recupère le joueur inscrit
		Object joueurObj = session.getAttribute("joueur");
//on verifie que le joueur existe dejà et on lui lie l'animal qu'on a recuperé avec l'id, on update notre base de données
		if (joueurObj != null) {
			Joueur joueur = (Joueur) joueurObj;
			joueur.setAnimal(animal);
			daoJoueur.createOrUpdate(joueur);
		}
		model.addAttribute("listeJeux", jeuxDao.findAll());
		System.out.println(jeuxDao.findAll().size());

		return "animaljoueur";
	}
}
