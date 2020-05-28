package com.Balvas.Autowire;

public class Octopus implements Animal_A {

	Heart octopusHeart;

	public Octopus() {
	}

	public Octopus(Heart octopusHeart) {
		this.octopusHeart = octopusHeart;
	}

	public void setOctopusHeart(Heart octopusHeart) {
		this.octopusHeart = octopusHeart;
	}

	@Override
	public void getDetails() {
		System.out.println("Calling Octopus Class");
		System.out.println(octopusHeart.getHeartCount());
	}

}
