package com.sample.sample_API;

import static spark.Spark.*;

import org.bson.types.ObjectId;

import com.google.gson.*;

//API routes
public class App {
	
	public static PayrollService payrollService = new PayrollService();
	
	public static void main(String[]args) {
		final Gson gson = new Gson();
		
		//Add an employee to payroll
		post("/add-employee", (req, res) -> {
			Employee newEmployee = gson.fromJson(req.body(), Employee.class);
			return payrollService.addEmployee(newEmployee);
		}, gson::toJson);
		
		//Get all employees
		get("/", (req, res) -> {
			res.type("application/json");
			return payrollService.getAllEmployees();
		}, gson::toJson);
				
		//Find employee by ID
		get("/:id", (req, res) -> {
			res.type("application/json");
			//Convert passed ID parameter from String to Object ID
			ObjectId id = new ObjectId(req.params(":id"));
			Employee employee = payrollService.getEmployeeById(id);
			System.out.println(employee);
			if (employee != null) {
				return employee;
			} else {
				return "Could not find employee.";
			}
		}, gson::toJson);
		
		//Remove employee from payroll
		delete("/delete-employee/:id", (req, res) -> {
			res.type("application/json");
			//Convert passed ID parameter from String to Object ID
			ObjectId id = new ObjectId(req.params(":id"));
			Employee employee = payrollService.removeFromPayroll(id);
			if (employee != null) {
				return employee.getName() + " was removed from payroll.";
			} else {
				return null;
			}
		}, gson::toJson);
		
	}
    
}