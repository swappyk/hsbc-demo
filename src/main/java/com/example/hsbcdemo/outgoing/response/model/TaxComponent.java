package com.example.hsbcdemo.outgoing.response.model;

public class TaxComponent {

	private double federalTax;
	private double stateTax;
	private double variableTax;

	public TaxComponent() {

	}

	public double getFederalTax() {
		return federalTax;
	}

	public void setFederalTax(double federalTax) {
		this.federalTax = federalTax;
	}

	public double getStateTax() {
		return stateTax;
	}

	public void setStateTax(double stateTax) {
		this.stateTax = stateTax;
	}

	public double getVariableTax() {
		return variableTax;
	}

	public void setVariableTax(double variableTax) {
		this.variableTax = variableTax;
	}

}
