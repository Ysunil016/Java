package com.Balvas.Autowire.Annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Human_Ann implements Animal_Ann {

	@Autowired
	@Qualifier("humanHeartAnn")
	Heart_Ann humanHeart;

	// @Autowired Tag at Dependency First Hunts for Bean with byType in IOC, If
	// Found OKAY, In case found Multiple, then Goes for byName..
	// It Need Not Require BoilerPlate for Setter or Constructor as Applying
	// @Autowired at Dependency Itself Manages Everything Internally.

	@Override
	public void getDetails() {
		System.out.println("Calling Human Annotations Class");
		System.out.println(humanHeart.getHeartCount());
	}

}
