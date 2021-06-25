package model.entities;

import java.util.Date;

import model.exceptions.DomainException;

public class CarRental {
	private Date start,finish;
	private Vehicle car;
	private Invoice invoice;
	
	public CarRental(Date start, Date finish, Vehicle car) throws DomainException {
		if(!finish.after(start)) {
			throw new DomainException("The rental start date must be later than the end date!");
		}
		this.start = start;
		this.finish = finish;
		this.car = car;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Vehicle getCar() {
		return car;
	}

	public void setCar(Vehicle car) {
		this.car = car;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}
