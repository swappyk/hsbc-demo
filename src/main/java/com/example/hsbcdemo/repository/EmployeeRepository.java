package com.example.hsbcdemo.repository;

import com.example.hsbcdemo.incoming.request.model.Employee;

public interface EmployeeRepository {

	public Employee getEmployeeDetails(Integer emplid);

}
