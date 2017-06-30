package com.sample.sample_API;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

//Employee Object for Payroll API
@Entity
public class Employee {
	@Id
	private ObjectId id;
	
	//Need to use non-primitives to check for nulls later
	private String name;
	private Double salary;
	private Boolean newHire;
		
	public Employee() {
	}
		
	public ObjectId getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
		
	public Double getSalary() {
		return salary;
	}
		
	public Boolean getHireStatus() {
		return newHire;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	public void setSalary(double salary) {
		this.salary = salary;
	}
		
	public void setHireStatus(boolean newHire) {
		this.newHire = newHire;
	}
		
	public String toString() {
		return "Name: " + name + "\nSalary: $" + salary + "\nIs New Hire: " + newHire + "\n";
	}
		
}