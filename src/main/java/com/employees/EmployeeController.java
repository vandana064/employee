package com.employees;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RestController
public class EmployeeController {

	@GetMapping("employee/list")
	public ResponseEntity<Object> getEmployeeList() {
		MongoClient mongoCollection = null;
		try {
			mongoCollection = new MongoClient("1.1.1.1", 27017);
			MongoDatabase database = mongoCollection.getDatabase("myDatabase");
			MongoCollection<Document> employeeCollection = database.getCollection("employees");
			List<Document> employees = employeeCollection.find().into(new ArrayList<Document>());
			for (Document employee : employees) {
				employee.remove("_id").toString();
			}
			return new ResponseEntity<>(employees.toString(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mongoCollection.close();
		}

		return null;

	}

	@PostMapping("employee")
	public Employee postEmployee(@RequestBody Employee employee) {
		MongoClient mongoCollection = null;
		try {
			mongoCollection = new MongoClient("1.1.1.1", 27017);
			MongoDatabase database = mongoCollection.getDatabase("myDatabase");
			MongoCollection<Document> employeeCollection = database.getCollection("employees");
			employeeCollection.insertOne(Document.parse(new ObjectMapper().writeValueAsString(employee)));
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mongoCollection.close();
		}

		return null;

	}
}
