package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.exceptions.DomainException;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		try {
			
			System.out.println("Enter renta data");
			System.out.print("Car model: ");
			String model = sc.next();
			sc.nextLine();
			System.out.print("Pickup (dd/MM/yyyy HH:mm): ");
			Date dateStart = sdf.parse(sc.nextLine());
			System.out.print("Return (dd/MM/yyyy HH:mm): ");
			Date dateFinish = sdf.parse(sc.nextLine());
			CarRental carRental = new CarRental(dateStart, dateFinish, new Vehicle(model));
			
			System.out.print("Enter price per hour: ");
			double pricePerHour = sc.nextDouble();
			System.out.print("Enter price per day: ");
			double pricePerDay = sc.nextDouble();
			RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
			rentalService.processInvoice(carRental);
			
			System.out.println("INVOICE: ");
			System.out.println("Basic payment: "+ String.format("%.2f", carRental.getInvoice().getBasicPayment()));
			System.out.println("Tax: "+String.format("%.2f", carRental.getInvoice().getTaxService()));
			System.out.println("Total payment: "+ String.format("%.2f",carRental.getInvoice().totalPayment()));
			
		} catch (ParseException e) {
			System.out.println("Invalid date format");
			e.printStackTrace();
		} catch (DomainException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e.getMessage());
		} finally {
			sc.close();
		}
	}

}
