package com.Balvas.Annotations.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Primary , this will Priorities the Class based on Interface. 
public class LinkedListHashMapClass {

	@Autowired
	@Qualifier("collectionsClass")
	CollectionsClass collectionsClass;

	public void getInfo() {
		System.out.println("Inside LinkedList Map " + collectionsClass.getVal());
	}

}
