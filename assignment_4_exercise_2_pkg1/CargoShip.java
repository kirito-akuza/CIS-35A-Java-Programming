/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 4 - Exercise 2
 * Due Date: 02/27/2022
 * Date Submitted: 02/27/2022
 */

package assignment_4_exercise_2_pkg1;

public class CargoShip extends Ship {
	
	// Declare variables
	private String cargotype;
	private double numberofcranes, cargovalue;
	
	// Constructor
	public CargoShip(String name, String origin, String owner, String cargotype, int capacity, double length, double width, double height, double numberofcranes, double cargovalue, String departuredate, String arrivaldate) {
		super(name, origin, owner, capacity, length, width, height, departuredate, arrivaldate);
		this.cargotype = cargotype;
		this.cargovalue = cargovalue;
		this.numberofcranes = numberofcranes;
	}
	
	// Setters - Mutators
	public void setCargoType(String cargotype) {
		this.cargotype = cargotype;
	}
	
	public void setNumberofCranes(double numberofcranes) {
		this.numberofcranes = numberofcranes;
	}
	
	public void setCargoValue(double cargovalue) {
		this.cargovalue = cargovalue;
	}
	
	// Getters - Accessors
	public String getCargoType() {
		return cargotype;
	}
	
	public double getNumberofCranes() {
		return numberofcranes;
	}
	
	public double getCargoValue() {
		return cargovalue;
	}
	
	// Overriden class method printDetails
	public void printDetails() {
		super.printDetails();
		System.out.printf("Cargo Type: %s\n", this.getCargoType());
		System.out.printf("Number of cranes: %.2f\n", this.getNumberofCranes());
		System.out.printf("Cargo Value: %.2f\n", this.getCargoValue());
	}
	
	// Overriden class method printSize
	public void printSize() {
		System.out.printf("Cargo Length: %.2f\n", this.getLength());
		System.out.printf("Cargo Width: %.2f\n", this.getWidth());
		System.out.printf("Cargo Height: %.2f\n", this.getHeight());
	}
	
	// Overriden class method printDate
	public void printDate() {
		System.out.printf("Cargo Departure Date: %s\n", this.getDepartureDate());
		System.out.printf("Cargo Arrival Date: %s\n", this.getArrivalDate());
	}
	
}
