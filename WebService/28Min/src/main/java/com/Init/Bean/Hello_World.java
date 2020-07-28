package com.Init.Bean;

public class Hello_World {

	private String Name;
	private int Age;
	private String City;
	private String Country;

	public String getName() {
		return Name;
	}

	public int getAge() {
		return Age;
	}

	public String getCity() {
		return City;
	}

	public String getCountry() {
		return Country;
	}

	public Hello_World(String name, int age, String city, String country) {
		Name = name;
		Age = age;
		City = city;
		Country = country;
	}

}
