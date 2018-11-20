package fr.dawan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.dawan.DAO.InterfaceDao;
import fr.dawan.beans.Animal;

@Controller
public class AnimalController {
	@Autowired
	@Qualifier("hibernateDao2")
	private InterfaceDao<Animal> daoAnimal;
	
	@PostMapping("/creaanimal")
	public String createAnimal(Animal animal, Model model) {
		
		animal=daoAnimal.createOrUpdate(animal);
		model.addAttribute("msg", "Animal ajouté !");
		
		return "listeanimal";
		
	}
	
	
}
