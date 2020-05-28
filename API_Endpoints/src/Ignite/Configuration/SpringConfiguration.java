package Ignite.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import Ignite.Medical.Corona.CoronaRapidAPI;

@Configuration
@ComponentScan(basePackages = { "Ignite" })
@PropertySource("classpath:corona.properties")
public class SpringConfiguration {

	@Bean("CORONA_RAPID_API_ALL")
	public CoronaRapidAPI getCoronaStats() {
		return new CoronaRapidAPI();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
