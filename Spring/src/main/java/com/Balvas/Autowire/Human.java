package com.Balvas.Autowire;

public class Human implements Animal_A {

	Heart humanHeart;

	public Human() {
	}

	public Human(Heart humanHeart) {
		this.humanHeart = humanHeart;
	}

	public void setHumanHeart(Heart humanHeart) {
		this.humanHeart = humanHeart;
	}

	@Override
	public void getDetails() {
		System.out.println("Calling Human Class");
		System.out.println(humanHeart.getHeartCount());
	}

}
