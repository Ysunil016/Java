package com.Init.Bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel("User Bean")
public class User {

	@javax.persistence.Id
	@GeneratedValue
	private Integer Id;

	@ApiModelProperty("In Between 6 and 20")
	@Size(min = 6, max = 20, message = "Name Should be In Between 6-20")
	private String name;

	@ApiModelProperty("Cannot be in Future")
	@Past(message = "Please Use Past Date")
	private Date birthDate;

	public User() {
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

	public User(Integer id, String name, Date birthDate) {
		super();
		Id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

}
