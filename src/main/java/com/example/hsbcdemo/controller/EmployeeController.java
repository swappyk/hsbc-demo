package com.example.hsbcdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hsbcdemo.outgoing.response.model.Salary;
import com.example.hsbcdemo.service.implementation.EmployeeServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/rest")
@Api(value="Employee Resource", description="Retrieves salary structure for a particular employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;

	@GetMapping("/getEmployeeSalary/{emplid}")
	@ApiOperation(value = "Returns the salary structure of the given employee")
	public ResponseEntity<Salary> getEmployeeSalary(@PathVariable Integer emplid) {

		return new ResponseEntity<Salary>(service.getEmployeeDetails(emplid), HttpStatus.OK);

	}

}
