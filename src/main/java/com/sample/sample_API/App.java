package com.sample.sample_API;
import static spark.Spark.*;
import com.google.gson.*;
import spark.*;

//API routes
public class App {
	
	static PayrollService payrollService = new PayrollService();
	
	public static void main(String[]args) {
		final Gson gson = new Gson();
		
		post("/add-employee", (req, res) -> {
			Employee newEmployee = gson.fromJson(res.body(), Employee.class);
			return payrollService.addEmployee(newEmployee);
		}, gson::toJson);
				
	}
    
}