package com.Balvas.DI;

public class Developer implements Employee {
	String employeeId;

	// Object Injection
	Repository repository;

	// Setter Type Object Injection
	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	public Developer(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public void getEmployeeDetails() {
		System.out.println(employeeId + " has " + repository.getSalary(employeeId) + " Salary as Developer");
	}

}
