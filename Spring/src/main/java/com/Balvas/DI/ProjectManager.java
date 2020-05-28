package com.Balvas.DI;

public class ProjectManager implements Employee {
	String employeeId;

	// Object Injection
	Repository repository;

	// Setter Type Object Injection
	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	public ProjectManager(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public void getEmployeeDetails() {
		System.out.println(employeeId + " has " + repository.getSalary(employeeId) + " Salary as Project Manager");
	}
}
