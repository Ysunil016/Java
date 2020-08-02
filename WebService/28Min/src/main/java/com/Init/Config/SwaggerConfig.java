package com.Init.Config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Sunil", "", "sunil016@yahoo.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("28 Min", "Learning Mode", "4.0", "urn:tos",
			DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());

	private static final Set<String> DEFAULT_PRODUCES = new HashSet<String>();

	@Bean
	public Docket getDocker() {
		DEFAULT_PRODUCES.add("application/json");
		DEFAULT_PRODUCES.add("application/xml");
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).produces(DEFAULT_PRODUCES)
				.consumes(DEFAULT_PRODUCES);
	}

}
