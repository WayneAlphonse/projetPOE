package fr.dawan.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
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
	private MessageSource messageSource;

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
	public String createGame(Jeux jeux, Locale locale,Model model) {
		jeuDao.createOrUpdate(jeux);
		
		model.addAttribute("msg", messageSource.getMessage("JOUET_CREE", null, locale));

		return "animaljoueur";
	}

	@PostMapping("/creadodo")
	public String createSleep(Dodo dodo, Locale locale, Model model) {
		dodoDao.createOrUpdate(dodo);
		
		model.addAttribute("msg", messageSource.getMessage("DODO_CREE", null, locale));

		return "animaljoueur";
	}

	@PostMapping("/creanourriture")
	public String createFood(Nourriture nourriture,Locale locale, Model model) {
		nourritureDao.createOrUpdate(nourriture);
		
		model.addAttribute("msg",messageSource.getMessage("NOURRITURE_CREE", null, locale));

		return "animaljoueur";
	}

}
