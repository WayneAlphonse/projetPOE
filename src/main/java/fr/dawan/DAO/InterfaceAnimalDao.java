package fr.dawan.DAO;

import java.util.List;

import fr.dawan.beans.Animal;
import fr.dawan.beans.TypeAnimal;

public interface InterfaceAnimalDao<T> extends InterfaceDao<T> {

	List<Animal> findByEnum(TypeAnimal typeAnimal);
}
