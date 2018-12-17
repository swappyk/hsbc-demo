package com.example.hsbcdemo.repository.implementation;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.hsbcdemo.customexception.EmployeeNotFoundException;
import com.example.hsbcdemo.incoming.request.model.Employee;
import com.example.hsbcdemo.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private List<Employee> empList = Arrays.asList(new Employee(1, "A", 1000.00, "California"),
			new Employee(2, "B", 2000.00, "Texas"), new Employee(3, "C", 3000.00, "California"),
			new Employee(4, "D", 4000.00, "Texas"));

	public Employee getEmployeeDetails(Integer emplid) {

		// The below java8 syntax is working but to show case exception handling
		// I have used java7 version
		// return empList.stream().filter(e -> e.getEmplId() ==
		// emplid).findFirst().get();

		Employee emp = null;

		for (Employee e : empList) {
			if (e.getEmplId().equals(emplid)) {
				emp = e;
				break;
			}
		}
		if (emp == null) {
			throw new EmployeeNotFoundException("Employee with id " + emplid + " is not found");
		}

		return emp;
	}
}