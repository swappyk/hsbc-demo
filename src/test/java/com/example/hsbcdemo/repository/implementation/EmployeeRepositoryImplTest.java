package com.example.hsbcdemo.repository.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.hsbcdemo.incoming.request.model.Employee;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRepositoryImplTest {

	@InjectMocks
	private EmployeeRepositoryImpl repo;

	@Test
	public void test_getEmployeeDetails_EmployeeFound() {

		Employee expectedEmployee = new Employee(1, "A", 1000.00, "California");
		Employee actualEmployee = repo.getEmployeeDetails(1);
		assertEquals(expectedEmployee.getEmplId(), actualEmployee.getEmplId());
		assertEquals(expectedEmployee.getEmpName(), actualEmployee.getEmpName());
	}
	
	@Test
	public void test_getEmployeeDetails_EmployeeNotFound() {

		Employee actualEmployee = repo.getEmployeeDetails(1);
		assertNotNull(actualEmployee);
	}
	
	
}
