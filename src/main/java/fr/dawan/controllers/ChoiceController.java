package fr.dawan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.DAO.InterfaceDao;
import fr.dawan.beans.Animal;

@Controller
public class ChoiceController {

	
	@Autowired
	@Qualifier("hibernateDao2")
	private InterfaceDao<Animal> daoAnimal;
	
	@PostMapping(value = "/choice")
	public String redirectListAnimal(Model model) {
		

		model.addAttribute("listeAnimals", daoAnimal.findAll());

		return "listeanimal";
	}

}
