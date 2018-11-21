package fr.dawan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.dawan.DAO.InterfaceDao;
import fr.dawan.beans.Jeux;



@Controller
public class AnimalJoueurController {
	
	@Autowired
	@Qualifier("hibernateDao3")
	private InterfaceDao<Jeux> jeuxDao;
	
	@GetMapping("")
	public String affiche(Model model) {
		
		
	
		
		return"animaljoueur";
	}

	
}
