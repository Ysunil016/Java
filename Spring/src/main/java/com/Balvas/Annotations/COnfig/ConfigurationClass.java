package com.Balvas.Annotations.COnfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.Balvas.Annotations.Bean.CollectionsClass;

@Configuration
@ComponentScan("com.Balvas.Annotations")
public class ConfigurationClass {

	@Bean("sunilYadav")
	public CollectionsClass getCollectionClass() {
		return new CollectionsClass();
	}
//
//	@Bean(name="sunilYadav")
//	public CollectionsClass getCollection2Class() {
//		return new CollectionsClass();
//	}
//
//	@Bean
//	public HashMapClass getHashClass() {
//		return new HashMapClass();
//	}
//
//	@Bean
//	public LinkedListHashMapClass getLinkedList() {
//		return new LinkedListHashMapClass();
//	}

}
