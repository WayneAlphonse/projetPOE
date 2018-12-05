package fr.dawan.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.dawan.DAO.InterfaceAnimalDao;
import fr.dawan.beans.Animal;
import fr.dawan.utils.Constantes;

@Controller
public class AnimalController {
	@Autowired
	@Qualifier("hibernateDao2")
	private InterfaceAnimalDao<Animal> daoAnimal;

	@PostMapping("/creaanimal")
	public String createAnimal(Animal animal, Model model) {

		daoAnimal.createOrUpdate(animal);
//		model.addAttribute("listeAnimals", daoAnimal.findAll());
//		model.addAttribute("msg", Constantes.ANIMAL_AJOUTE);

		return "uploadimage";

	}

	@PostMapping("/upload")
	public String ajouterImage(Model model, Locale locale, HttpServletRequest request,
			@RequestParam("image_animal") MultipartFile file, @RequestParam("id") int id) {

		// Le chemin correspond au répertoire upload
		String path = request.getServletContext().getRealPath("static/upload");
		System.out.println(path);

		// on crée un objet de type File à partir de ce chemin
		// (File peut être un fichier OU un répertoire
		File directory = new File(path);
		// est ce que ce répertoire / fichier existe dans la vraie vie ?
		if (!directory.exists()) {
			// Sinon, on le crée
			directory.mkdirs();
		}

		try {
			// Ecriture du fichier sur le serveur (dans le répertoire "static/upload")
			File fichierDestination = new File(directory, new Date().getTime() + "_" + file.getOriginalFilename());
			FileOutputStream stream = new FileOutputStream(fichierDestination);
			stream.write(file.getBytes());
			stream.close();

			// récupération de l'objet animal à partir de la base de données
			Animal animal = daoAnimal.findById(id);

			if (animal != null) {
				// modification de l'animal
				animal.setNomImage(fichierDestination.getName());

				// MaJ en BDD
				daoAnimal.createOrUpdate(animal);
				model.addAttribute("msg", Constantes.ANIMAL_AJOUTE);
			}
			else {
				model.addAttribute("msg", Constantes.ANIMAL_AJOUTE_ERROR);
			}

			model.addAttribute("listeAnimals", daoAnimal.findAll());
			return "listeanimal";

		} catch (Exception ex) {
			ex.printStackTrace();
			return "listeanimal";
		}
	}

}
