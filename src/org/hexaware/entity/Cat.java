package org.hexaware.entity;

public class Cat extends Pet{
	private String catBreed;

	public Cat(String name, int age, String type,int availableForAdoption,String catBreed) {
		super(name, age, type,availableForAdoption);
		this.catBreed=catBreed;
	}

	public String getCatBreed() {
		return catBreed;
	}

	public void setCatBreed(String catBreed) {
		this.catBreed = catBreed;
	}
	 @Override
	    public String toString() {
	        return super.toString() + ", CatBreed=" + catBreed + "]";
	    }
}
