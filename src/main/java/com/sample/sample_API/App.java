package com.sample.sample_API;

import static spark.Spark.*;

import org.bson.types.ObjectId;

import com.google.gson.*;

//API routes
public class App {
	
	public static PayrollService payrollService = new PayrollService();
	
	public static void main(String[]args) {
		final Gson gson = new Gson();
		
		post("/add-employee", (req, res) -> {
			Employee newEmployee = gson.fromJson(req.body(), Employee.class);
			return payrollService.addEmployee(newEmployee);
		}, gson::toJson);
		
		get("/", (req, res) -> {
			res.type("application/json");
			return payrollService.getAllEmployees();
		}, gson::toJson);
				
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