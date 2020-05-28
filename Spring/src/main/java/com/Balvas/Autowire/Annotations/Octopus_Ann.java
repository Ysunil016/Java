package com.Balvas.Autowire.Annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Octopus_Ann implements Animal_Ann {

	Heart_Ann octopusHeart;

	public Octopus_Ann() {
	}

	public Octopus_Ann(Heart_Ann octopusHeart) {
		this.octopusHeart = octopusHeart;
	}

	@Autowired
	@Qualifier("octopusHeartAnn")
	public void setOctopusHeart(Heart_Ann octopusHeart) {
		this.octopusHeart = octopusHeart;
	}

	@Override
	public void getDetails() {
		System.out.println("Calling Octopus Annotations Class");
		System.out.println(octopusHeart.getHeartCount());
	}

}
