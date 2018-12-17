package com.example.hsbcdemo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.hsbcdemo.outgoing.response.model.Salary;
import com.example.hsbcdemo.outgoing.response.model.TaxComponent;
import com.example.hsbcdemo.service.implementation.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	@InjectMocks
	private EmployeeController controller;

	@Mock
	private EmployeeServiceImpl service;

	private static Salary expectedSalary;
	private static ResponseEntity<Salary> expectedResponseEntity;

	@BeforeClass
	public static void initializeResponseEntitiy() {
		TaxComponent taxComponent = new TaxComponent();
		taxComponent.setFederalTax(200);
		taxComponent.setStateTax(90);
		taxComponent.setVariableTax(50);
		expectedSalary = new Salary(1000.00, taxComponent, 660.00);
		expectedResponseEntity = new ResponseEntity<Salary>(expectedSalary, HttpStatus.OK);

	}

	@Test
	public void test_getEmployeeSalary() {

		when(service.getEmployeeDetails(Mockito.anyInt())).thenReturn(expectedSalary);

		assertEquals(expectedResponseEntity, controller.getEmployeeSalary(1));

	}

}
