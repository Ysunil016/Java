package com.Balvas.Annotations.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class CollectionsClass {

	// Creating Init Function for this Bean Class
	@PostConstruct
	public void init() {
		System.out.println("Post Construct Function of Collection Bean");
	}

	public String getVal() {
		System.out.println("Inside Collection Class");
		return "Sunil";
	}

	// Creating Init Function for this Bean Class
	@PreDestroy
	public void destroy() {
		System.out.println("Pre Destroy Function of Collections Bean");
	}
}
