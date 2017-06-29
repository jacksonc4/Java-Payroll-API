package com.sample.sample_API;
import org.bson.types.ObjectId;

//Employee Object for Payroll API
public class Employee {
	private ObjectId id;
	private String name;
	private double salary;
	private boolean newHire;
		
	public Employee(ObjectId id, String name, double salary, boolean newHire) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.newHire = newHire;
	}
		
	public ObjectId getID() {
		return id;
	}
		
	public String getName() {
		return name;
	}
		
	public double getSalary() {
		return salary;
	}
		
	public boolean getHireStatus() {
		return newHire;
	}
		
	public void setID(ObjectId id) {
		this.id = id;
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
		return "ObjectID: " + id + "\nName: " + name + "\nSalary: " + salary + "\nIs New Hire: " + newHire + "\n";
	}
		
}
