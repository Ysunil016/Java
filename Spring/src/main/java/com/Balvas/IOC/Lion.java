package com.Balvas.IOC;

public class Lion implements Animal {

	private String animalName;
	private int averageAge;
	private String familyName;
	private int totalPopulation;

	public Lion() {
		System.out.println("************ Lion Object Created ************");
	}

	Lion(String animalName, String familyName) {
		System.out.println("************ Lion Constructor DI ************");

		this.animalName = animalName;
		this.familyName = familyName;
	}

	public void setAverageAge(int averageAge) {
		System.out.println("************ Lion Setter DI ************");

		this.averageAge = averageAge;
	}

	public void setTotalPopulation(int totalPopulation) {
		System.out.println("************ Lion Setter DI ************");

		this.totalPopulation = totalPopulation;
	}

	@Override
	public void getDetails() {
		System.out.println("Name: " + animalName);
		System.out.println("Avergae Age: " + averageAge);

		System.out.println("Family Name: " + getFamilyName());
		System.out.println("Population Counter: " + getPopulation());
	}

	@Override
	public String getFamilyName() {
		return familyName;
	}

	@Override
	public int getPopulation() {
		return totalPopulation;
	}

	public void init() {
		System.out.println("Init Bean using XML");
	}

	public void destroy() {
		System.out.println("Destroy Bean using XML");
	}

}
