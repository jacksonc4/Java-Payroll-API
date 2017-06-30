package com.sample.sample_API;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;

//Service functions
public class PayrollService {
	MongoClient client = new MongoClient("localhost", 27017);
	Datastore datastore = new Morphia().createDatastore(client, "payroll");
	
	//Add a new employee
	public String addEmployee(Employee employee) {
		datastore.save(employee);
		
		return "Added employee " + employee.getId();
	}
	
	//Get employee by ID 
	public Employee getEmployeeById(ObjectId id) {
		Employee employee = datastore.get(Employee.class, id);
		System.out.println(employee);
		
		if (employee != null) {
			return employee;
			
		}
		
		//Return null if no employee is found
		return null;
		
	}
	
	//Remove employee from payroll
	public Employee removeFromPayroll(ObjectId id) {
		Employee employee = datastore.get(Employee.class, id);
			
		if (employee != null) {
			datastore.delete(employee);
			System.out.println("Employee " + employee.getName() + " removed from payroll.");
			return employee;
		}
			
		//Return null if no employee is found
		return null;
					
	}
	
	//Update an employee
	public Employee updateEmployee(ObjectId id, Employee updatedEmployee) {
		Employee employee = datastore.get(Employee.class, id);
		
		if (employee != null) {
			if (updatedEmployee.getSalary() != null) {
				employee.setSalary(updatedEmployee.getSalary());
			}

			if (updatedEmployee.getHireStatus() != null) {
				employee.setHireStatus(updatedEmployee.getHireStatus());
			}

			datastore.save(employee);
			return employee;
		}
		
		//Return null if no employee is found
		return null;
		
	}

	//Get list of employees
	public List<Employee> getAllEmployees() {
		List<Employee> allHires = datastore.find(Employee.class).asList();
		
		if (allHires != null) {
			return allHires;
		}

		//Return null if no employees are found
		return null;
		
	}
	
}