package com.example.hsbcdemo.outgoing.response.model;

public class Salary {

	private Double totalSalary;
	private TaxComponent taxComponent;
	private Double inHandSalary;

	public Salary(Double totalSalary, TaxComponent taxComponent, Double inHandSalary) {
		super();
		this.totalSalary = totalSalary;
		this.taxComponent = taxComponent;
		this.inHandSalary = inHandSalary;
	}

	public Double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(Double totalSalary) {
		this.totalSalary = totalSalary;
	}

	public TaxComponent getTaxComponent() {
		return taxComponent;
	}

	public void setTaxComponent(TaxComponent taxComponent) {
		this.taxComponent = taxComponent;
	}

	public Double getInHandSalary() {
		return inHandSalary;
	}

	public void setInHandSalary(Double inHandSalary) {
		this.inHandSalary = inHandSalary;
	}

}
