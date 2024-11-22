package org.hexaware.entity;

public class Pet {
	private String name;
    private int age;
    private String type;
    private int availableForAdoption;

    public Pet(String name, int age, String type,int availableForAdoption) {
		super();
		this.name = name;
		this.age = age;
		this.type = type;
		this.availableForAdoption=availableForAdoption;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String gettype() {
		return type;
	}
	public void settype(String type) {
		this.type = type;
	}
	
	public int getAvailableForAdoption() {
		return availableForAdoption;
	}
	public void setAvailableForAdoption(int availableForAdoption) {
		availableForAdoption = availableForAdoption;
	}
	@Override
	public String toString() {
		return "Pet [name=" + name + ", age=" + age + ", type=" + type + "]";
	}
	
}
