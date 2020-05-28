package com.Balvas.Annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.Balvas.Annotations.Bean.HashMapClass;
import com.Balvas.Annotations.COnfig.ConfigurationClass;

public class Ignite {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationClass.class);

		// Registering to Close Context when Main Thread at Closing State.
//		context.registerShutdownHook();

		HashMapClass hClass = context.getBean("hashMapClass", HashMapClass.class);
		hClass.getInfo();

		// INstant Context Closing
		((AnnotationConfigApplicationContext) context).close();

	}

}
