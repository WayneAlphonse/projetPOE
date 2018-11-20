package fr.dawan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import fr.dawan.DAO.InterfaceAnimalDao;
import fr.dawan.DAO.InterfaceDao;
import fr.dawan.beans.Animal;
import fr.dawan.beans.Chat;

@Controller
public class AnimalController {
	@Autowired
	@Qualifier("hibernateDao2")
	private InterfaceAnimalDao<Animal> daoAnimal;

	@PostMapping("/creaanimal")
	public String createAnimal(Animal animal, Model model) {

		daoAnimal.createOrUpdate(animal);
		model.addAttribute("listeAnimals", daoAnimal.findAll());
		model.addAttribute("msg", "Animal ajouté !");

		return "listeanimal";

	}

}
