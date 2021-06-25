package model.entities;

public class Invoice {
	private Double basicPayment,tax,taxService;
	
	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
		this.taxService = tax*basicPayment;
	}

	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	public Double getTaxService() {
		return taxService;
	}

	public Double totalPayment() {
		return basicPayment + taxService;
	}
}
