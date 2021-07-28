# REST API Project

**Author -** Connect me on [LinkedIn](https://www.linkedin.com/in/sagarkhati/)

## Adding Base Code

src

-main

--java

---com.sagarkhati.restapi

----RestApiApplication.java

--resource

---application.properties

-test

--java

---com.sagarkhati.restapi

----RestApiApplicationTests.java

## Adding model

package com.sagarkhati.restapi.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

@Entity

public class Employee {
	
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int empId;

	private String fname;

	private String lname;

	private String designation;
	
	public Employee() {

	}

	public Employee(String fname, String lname, String designation) {

		this.fname = fname;

		this.lname = lname;

		this.designation = designation;

	}
	
	public int getEmpId() {

		return empId;

	}

	public void setEmpId(int empId) {

		this.empId = empId;

	}

	public String getFname() {

		return fname;

	}

	public void setFname(String fname) {

		this.fname = fname;

	}

	public String getLname() {

		return lname;

	}

	public void setLname(String lname) {

		this.lname = lname;

	}

	public String getDesignation() {

		return designation;

	}

	public void setDesignation(String designation) {

		this.designation = designation;

	}

}

## Updating application.properties

spring.h2.console.enabled=true

spring.datasource.url=jdbc:h2:mem:testdb

Since spring boot 2.5.0 the data.sql is executed before the schema initialization by default

spring.jpa.defer-datasource-initialization=true

spring.jpa.show-sql=true

## Adding data.sql

insert into EMPLOYEE values(10001, 'ASE', 'Sagar', 'Khati');

insert into EMPLOYEE values(10002, 'ASE', 'S', 'Khati');

insert into EMPLOYEE values(10003, 'ASE', 'First', 'Last');

## Dependecies required till now

<dependency>

<groupId>org.springframework.boot</groupId>

<artifactId>spring-boot-starter-data-jpa</artifactId>

</dependency>

		
<dependency>

<groupId>com.h2database</groupId>

<artifactId>h2</artifactId>

<scope>runtime</scope>

</dependency>



