package fr.dawan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import fr.dawan.DAO.InterfaceDao;
import fr.dawan.beans.Jeux;

@Controller
public class ArtefactController {
	@Autowired
	@Qualifier("hibernateDao3")
	private InterfaceDao<Jeux> jeuDao;
	
	@PostMapping("/creajeux")
	public String createGame(Jeux jeux, Model model) {
		jeuDao.createOrUpdate(jeux);
		model.addAttribute("msg", "Jouet crée!");
		
		
		return "animaljoueur";
	}

}
