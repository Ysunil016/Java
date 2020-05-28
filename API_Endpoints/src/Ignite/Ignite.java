package Ignite;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import Ignite.Configuration.SpringConfiguration;
import Ignite.Interfaces.Medical.CoronaInterface;

public class Ignite {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		context.registerShutdownHook();

		CoronaInterface corona = context.getBean("CORONA_RAPID_API_ALL", CoronaInterface.class);
		corona.getAllStastic();

		context.close();
	}

}
