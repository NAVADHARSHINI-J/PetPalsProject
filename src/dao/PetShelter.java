package dao;

import org.hexaware.entity.Pet;

public interface PetShelter {
		boolean addPet(Pet pet);
		boolean removePet(int petId);
		int listAvailablePets();
}
