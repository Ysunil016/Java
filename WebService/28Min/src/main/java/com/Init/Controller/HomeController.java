package com.Init.Controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Init.Bean.Hello_World;

@RestController
@RequestMapping(value = "/v1")
public class HomeController {

	@Autowired
	private ResourceBundleMessageSource msgSource;

	@GetMapping(value = "/helloWorld")
	private String Home() {
		return "Hello-World";
	}

	@GetMapping(value = "/helloWorldBeanJSON", produces = MediaType.APPLICATION_JSON_VALUE)
	private Hello_World HomeBeanJSON() {
		Hello_World hW = new Hello_World("Sunil", 25, "Mumbai", "India");
		return hW;
	}

	@GetMapping(value = "/helloWorldBeanPathVariable/{name}/{age}/{city}/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
	private Hello_World HomeBeanPathVariable(@PathVariable("name") String name, @PathVariable("age") int age,
			@PathVariable("city") String city, @PathVariable("country") String country) {
		Hello_World hW = new Hello_World(name, age, city, country);
		return hW;
	}

	@GetMapping(value = "/helloWorld/International")
	private String HomeInternational(@RequestHeader(value = "Accept-Language", required = false) Locale locale) {
		return msgSource.getMessage("good.morning.message", null, locale);
	}

}
