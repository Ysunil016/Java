package com.Balvas.IOC;

public class Tiger implements Animal {

	private String animalName;
	private int averageAge;
	private String familyName;
	private int totalPopulation;

	public Tiger() {
		System.out.println("************ Tiger Object Created ************");
	}

	Tiger(String animalName, String familyName) {
		this.animalName = animalName;
		this.familyName = familyName;
	}

	public void setAverageAge(int averageAge) {
		this.averageAge = averageAge;
	}

	public void setTotalPopulation(int totalPopulation) {
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

}
