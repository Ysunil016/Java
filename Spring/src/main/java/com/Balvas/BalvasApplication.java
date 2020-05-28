package com.Balvas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Balvas.Autowire.Animal_A;
import com.Balvas.Autowire.Annotations.Animal_Ann;
import com.Balvas.DI.Employee;
import com.Balvas.IOC.Animal;

public class BalvasApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		System.out.println("\nIOC Concept\n");

		Animal animalInterface = context.getBean("animalInterface", Animal.class);
		animalInterface.getDetails();

		System.out.println("\nDI Concept\n");

		Employee employeeInterface = context.getBean("employeeInterfaceAsManager", Employee.class);
		employeeInterface.getEmployeeDetails();

		Employee employeeInterfaceD = context.getBean("employeeInterfaceAsDeveloper", Employee.class);
		employeeInterfaceD.getEmployeeDetails();

		System.out.println("\nAutowire Concept\n");

		Animal_A animalAInterface = context.getBean("animalAInterface", Animal_A.class);
		animalAInterface.getDetails();

		System.out.println("\nAutowire Annotations Concept\n");

		Animal_Ann animalAnnInterface = context.getBean("animalAnnInterface", Animal_Ann.class);
		animalAnnInterface.getDetails();

		((ClassPathXmlApplicationContext) context).close();

	}

}
