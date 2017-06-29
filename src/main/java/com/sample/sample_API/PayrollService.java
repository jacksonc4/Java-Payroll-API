package com.sample.sample_API;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;

//Service functions
public class PayrollService {
	MongoClient client = new MongoClient("localhost", 27017);
	Datastore datastore = new Morphia().createDatastore(client, "payroll");
	
	public String addEmployee(Employee employee) {
		datastore.save(employee);
		return "Employee Added";
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> allHires = datastore.find(Employee.class).asList();
		
		if (allHires != null) {
			return allHires;
		} 

		return null;
		
	}
	
}
