package dao;
public class Shelter implements Atobtable{

	 private String shelterName;
	    public Shelter(String shelterName) {
	        this.shelterName = shelterName;
	    }

	    @Override
	    public void adopt() {
	        System.out.println("Shelter \"" + shelterName + "\" is facilitating adoptions.");
	    }

	    @Override
	    public String toString() {
	        return shelterName;
	    }	
}
