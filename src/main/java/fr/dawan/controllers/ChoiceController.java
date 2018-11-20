package fr.dawan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.DAO.InterfaceAnimalDao;
import fr.dawan.DAO.InterfaceDao;
import fr.dawan.beans.Animal;
import fr.dawan.beans.TypeAnimal;

@Controller
public class ChoiceController {

	
	@Autowired
	@Qualifier("hibernateDao2")
	private InterfaceAnimalDao<Animal> daoAnimal;
	
	@PostMapping(value = "/choice")
	public String redirectListAnimal(Model model, @RequestParam("typeAnimal") TypeAnimal typeAnimal) {
		

		model.addAttribute("listeAnimals", daoAnimal.findByEnum(typeAnimal));

		return "listeanimal";
	}

}
