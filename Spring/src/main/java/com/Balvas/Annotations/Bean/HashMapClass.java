package com.Balvas.Annotations.Bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:Heart.properties")
public class HashMapClass implements InitializingBean, DisposableBean {

	@Value("${Human.heartCount}")
	int valued;

	@Autowired
	@Qualifier("sunilYadav")
	CollectionsClass collectionClas;

	public void getInfo() {
		System.out.println(valued);
		System.out.println("Inside Hash Map " + collectionClas.getVal());
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroying Bean using Interface");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("After DI to Object Init Bean using Interface");
	}

}
