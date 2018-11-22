package fr.dawan.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.dawan.DAO.InterfaceDao;
import fr.dawan.DAO.InterfaceJoueurDao;
import fr.dawan.beans.Dodo;
import fr.dawan.beans.Jeux;
import fr.dawan.beans.Joueur;
import fr.dawan.beans.Nourriture;

@Controller
public class LoginController {
	@Autowired
	private InterfaceJoueurDao<Joueur> dao;
	
	@Autowired
	@Qualifier("hibernateDao3")
	private InterfaceDao<Jeux> jeuxDao;
	
	@Autowired
	@Qualifier("hibernateDao5")
	private InterfaceDao<Nourriture> nourritureDao;
	
	@Autowired
	@Qualifier("hibernateDao4")
	private InterfaceDao<Dodo> dodoDao;
	

//	@PostMapping(value="/login", params= {"pseudo"})
//	
//	public String showChoice(Model model, @RequestParam String pseudo){
//			model.addAttribute("pseudo", pseudo);
//			
//			
//		
//		return "choice";
//	}

	@PostMapping(value = "/inscription", params = { "pseudo" })
	public String addPlayer(Model model, Joueur joueur, @RequestParam String pseudo, HttpSession session) {
		model.addAttribute("pseudo", pseudo);

		joueur = dao.createOrUpdate(joueur);
		session.setAttribute("joueur", joueur);
		return "choice";
	}

	@GetMapping("/login")
	public String showLogin() {
		return "login";
		
	}
	
	@PostMapping("/login")	
	public ModelAndView checkLogin(Joueur joueur, HttpSession session, Model model) {
		String returnUrl = "login";
		Joueur joueurFromDb = dao.findByEmail(joueur.getEmail());
		if (joueurFromDb != null && joueur.getEmail() != null && joueur.getPassword() != null && joueur.getEmail() != ""
				&& joueur.getPassword() != "" && joueur.getPassword().equals(joueurFromDb.getPassword())) {
			session.setAttribute("joueur", joueurFromDb);
			System.out.println(joueurFromDb.getPseudo());
			model.addAttribute("animal", joueurFromDb.getAnimal());
			model.addAttribute("listeNourriture", nourritureDao.findAll() );
			model.addAttribute("listeDodo", dodoDao.findAll());
			model.addAttribute("listeJeux", jeuxDao.findAll());
			returnUrl = "/animaljoueur";
		}

		return new ModelAndView(returnUrl);
	}
	
	public String MD5(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}

}

