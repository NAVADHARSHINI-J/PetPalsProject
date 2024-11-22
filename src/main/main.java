package main;

import java.util.Scanner;

import org.hexaware.entity.*;

import dao.*;
public class main {
		public static void main(String[] args) {
			PetShelter petShelter = new PetShelterImp();
			 AdoptionEvent adoptionEvent = new AdoptionEvent();
			Scanner scanner=new Scanner(System.in);
			boolean exit=false;
			while(!exit) {
			    System.out.println("\nSelect an option:");
		        System.out.println("1. Add a Pet");
		        System.out.println("2. Remove a Pet");
		        System.out.println("3. List Available Pets");
		        System.out.println("4. Record Cash Donation");
		        System.out.println("5. Record Item Donation");
		        System.out.println("6. Show Adoption Events");
		        System.out.println("7. Add Participant to Event");
		        System.out.println("8. Exit");
		        System.out.print("Enter your choice: ");			
			int ch=scanner.nextInt();
			scanner.nextLine();
			switch(ch) {
			 case 1:
				 System.out.println("\nAdd a Pet:");
                 System.out.print("Enter Pet Name: ");
                 String name = scanner.nextLine();

                 System.out.print("Enter Pet Age: ");
                 int age = scanner.nextInt();
                 scanner.nextLine();
                 System.out.print("Enter Pet Type (Dog/Cat): ");
                 String type = scanner.nextLine();

                 System.out.print("Is the pet available for adoption? (1 for Yes, 0 for No): ");
                 int availableForAdoption = scanner.nextInt();
                 scanner.nextLine(); 

                 boolean rs = false;
                 Pet pet;

                 if (type.equalsIgnoreCase("Dog")) {
                     System.out.print("Enter Dog Breed: ");
                     String dogBreed = scanner.nextLine();
                     pet = new Dog(name, age, type, availableForAdoption, dogBreed);
                     rs = petShelter.addPet(pet);
                 } else if (type.equalsIgnoreCase("Cat")) {
                     System.out.print("Enter Cat Breed: ");
                     String catBreed = scanner.nextLine();
                     pet = new Cat(name, age, type, availableForAdoption, catBreed);
                     rs = petShelter.addPet(pet);
                 } else {
                     System.out.println("Invalid Pet Type!");
                     break;
                 }

                 if (rs) {
                     System.out.println("Pet added successfully!");
                 } else {
                     System.out.println("Failed to add pet.");
                 }
                 break;
			 case 2:
				 System.out.println("\nRemove a Pet:");
                 System.out.print("Enter Pet ID: ");
                 int petId = scanner.nextInt();

                 if (petShelter.removePet(petId)) {
                     System.out.println("Pet removed successfully!");
                 } else {
                     System.out.println("Failed to remove pet.");
                 }
                 break;
			 case 3:
				 System.out.println("\nList Available Pets:");
                 int count = petShelter.listAvailablePets();
                 if (count > 0) {
                     System.out.println("Number of available pets for adoption: " + count);
                 } else {
                     System.out.println("No pets available for adoption or an error occurred.");
                 }
                 break;
			 case 4:
				 System.out.println("\nRecord Cash Donation:");
                 System.out.print("Enter Donor Name: ");
                 String cashDonorName = scanner.nextLine();
                 System.out.print("Enter Donation Date (YYYY-MM-DD): ");
                 String cashDonationDate = scanner.nextLine();
                 System.out.print("Enter Donation Type: ");
                 String cashDonationType = scanner.nextLine();
                 System.out.print("Enter Donation Amount: ");
                 double amount = scanner.nextDouble();
                 Donation cashDonation = new CashDonation(cashDonorName, cashDonationDate, cashDonationType, amount);
                 cashDonation.recordDonation(cashDonation);
                 break;
			 case 5:
				  System.out.println("\nRecord Item Donation:");
                  System.out.print("Enter Donor Name: ");
                  String itemDonorName = scanner.nextLine();
                  System.out.print("Enter Donation Date (YYYY-MM-DD): ");
                  String itemDonationDate = scanner.nextLine();
                  System.out.print("Enter Donation Type: ");
                  String itemDonationType = scanner.nextLine();
                  System.out.print("Enter Item Type (e.g., food, toys): ");
                  String itemType = scanner.nextLine();
                  Donation itemDonation = new ItemDonation(itemDonorName, itemDonationDate, itemDonationType, itemType);
                  itemDonation.recordDonation(itemDonation);
                  break;
			 case 6:
				 adoptionEvent.host();
                 break;
			 case 7:
				 System.out.println("Enter Participant Information:");
                 System.out.print("Enter Participant ID: ");
                 int participantId = scanner.nextInt();
                 scanner.nextLine(); 
                 System.out.print("Enter Participant Name: ");
                 String participantName = scanner.nextLine();                 
                 System.out.print("Enter Participant Type (e.g., Adopter, Shelter): ");
                 String participantType = scanner.nextLine();
                 System.out.print("Enter Event ID: ");
                 String eventId = scanner.nextLine();               
                 Partipants participant = new Partipants(participantId, participantName, participantType, eventId);
                 adoptionEvent.participant(participant);
                 break;
			 case 8:
				 System.out.println("Exited");
				 exit=true;
				 break;
			 default:
				 System.err.println("Wrong Option");
			}
			}
		}
}
