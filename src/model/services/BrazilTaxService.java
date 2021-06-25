package model.services;

public class BrazilTaxService implements TaxService{
	
	public double getTax(double amount) {
		if(amount <= 100.0) {
			return 0.20;
		}else {
			return 0.15;
		}
	}
}
