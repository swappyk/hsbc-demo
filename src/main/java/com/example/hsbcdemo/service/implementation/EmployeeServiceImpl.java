package com.example.hsbcdemo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.hsbcdemo.constants.AppConstants;
import com.example.hsbcdemo.incoming.request.model.Employee;
import com.example.hsbcdemo.outgoing.response.model.Salary;
import com.example.hsbcdemo.outgoing.response.model.TaxComponent;
import com.example.hsbcdemo.repository.EmployeeRepository;
import com.example.hsbcdemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Autowired
	private TaxComponent taxComponent;

	@Value("${variable.tax}")
	private String variableTax;

	public Salary getEmployeeDetails(Integer emplid) {
		Employee emp = repo.getEmployeeDetails(emplid);

		return new Salary(emp.getTotalSalary(), calculateTax(emp), calculateInHandSalary(emp.getTotalSalary()));
	}

	private TaxComponent calculateTax(Employee e) {

		if (AppConstants.VARIBLE_TAX_FLAG.equals(variableTax)) {
			taxComponent.setVariableTax(deductVariableTax(e.getTotalSalary()));
		}
		taxComponent.setFederalTax(calculateFederalTax(e.getTotalSalary()));
		taxComponent.setStateTax(calculateStateTax(e.getTotalSalary(), e.getState()));
		return taxComponent;
	}

	private Double deductVariableTax(Double totalSalary) {
		return totalSalary * AppConstants.VARIABLE_TAX_RATE / 100;

	}

	private Double calculateStateTax(Double totalSalary, String state) {
		double stateTaxRate = 0;
		double stateTax = 0;
		if (AppConstants.STATE_CALIFORNIA.equals(state)) {
			stateTaxRate = AppConstants.STATE_CALIFORNIA_TAX_RATE;
			stateTax = totalSalary * stateTaxRate / 100;
		}

		return stateTax;
	}

	private Double calculateFederalTax(Double totalSalary) {
		return totalSalary * AppConstants.FED_TAX_RATE / 100;

	}

	private Double calculateInHandSalary(Double totalSalary) {
		return totalSalary - taxComponent.getFederalTax() - taxComponent.getStateTax() - taxComponent.getVariableTax();

	}
}
