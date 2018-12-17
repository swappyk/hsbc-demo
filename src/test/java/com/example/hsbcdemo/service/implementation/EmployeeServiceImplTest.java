package com.example.hsbcdemo.service.implementation;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.TestPropertySource;

import com.example.hsbcdemo.incoming.request.model.Employee;
import com.example.hsbcdemo.outgoing.response.model.Salary;
import com.example.hsbcdemo.outgoing.response.model.TaxComponent;
import com.example.hsbcdemo.repository.implementation.EmployeeRepositoryImpl;

@RunWith(MockitoJUnitRunner.class)
@TestPropertySource(properties = "variable.tax=Y")
public class EmployeeServiceImplTest {

	@InjectMocks
	private EmployeeServiceImpl service;

	@Mock
	private EmployeeRepositoryImpl repo;

	@Spy
	private TaxComponent component;

	private static Salary expectedSalary;
	private static Employee expectedEmployee;

	@BeforeClass
	public static void intializeData() {

		expectedEmployee = new Employee(1, "A", 1000.00, "California");

		TaxComponent taxComponent = new TaxComponent();
		taxComponent.setFederalTax(200);
		taxComponent.setStateTax(90);
		taxComponent.setVariableTax(50);
		expectedSalary = new Salary(1000.00, taxComponent, 660.00);

	}

	@Test
	public void test_getEmployeeDetails_verifyFederalTax() {

		when(repo.getEmployeeDetails(Mockito.anyInt())).thenReturn(expectedEmployee);

		Double expectedFedTax = expectedSalary.getTaxComponent().getFederalTax();
		Double actualFedTax = service.getEmployeeDetails(1).getTaxComponent().getFederalTax();

		assertEquals(expectedFedTax, actualFedTax);

	}

	@Test
	public void test_getEmployeeDetails_verifyStateTax() {

		when(repo.getEmployeeDetails(Mockito.anyInt())).thenReturn(expectedEmployee);

		Double expectedStateTax = expectedSalary.getTaxComponent().getStateTax();
		Double actualStateTax = service.getEmployeeDetails(1).getTaxComponent().getStateTax();

		assertEquals(expectedStateTax, actualStateTax);

	}

	@Test
	public void test_getEmployeeDetails_verifyTotalSalary() {

		when(repo.getEmployeeDetails(Mockito.anyInt())).thenReturn(expectedEmployee);

		assertEquals(expectedSalary.getTotalSalary(), service.getEmployeeDetails(1).getTotalSalary());
	}

}
