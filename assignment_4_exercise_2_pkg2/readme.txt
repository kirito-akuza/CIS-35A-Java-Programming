/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 4 - Exercise 2
 * Due Date: 02/27/2022
 * Date Submitted: 02/27/2022
 */

Instruction to review and run code:

*****************************************Ship.java*****************************************************
package assignment_4_exercise_2_pkg1;

public class Ship {
	
	// Declare private variables
	private String name, origin, owner, departuredate, arrivaldate;
	private int capacity;
	private double length, width, height;
	
	// Constructor
	public Ship(String name, String origin, String owner, int capacity, double length, double width, double height, String departuredate, String arrivaldate) {
		this.name = name;
		this.origin = origin;
		this.owner = owner;
		this.capacity = capacity;
		this.length = length;
		this.width = width;
		this.height = height;
		this.departuredate = departuredate;
		this.arrivaldate = arrivaldate;
	}
	
	// Setters - Mutators
	protected void setName(String name) {
		this.name = name;
	}
	
	protected void setOrigin(String origin) {
		this.origin = origin;
	}
	
	protected void setOwner(String owner) {
		this.owner = owner;
	}
	
	protected void setDepartureDate(String departuredate) {
		this.departuredate = departuredate;
	}
	
	protected void setArrivalDate(String arrivaldate) {
		this.arrivaldate = arrivaldate;
	}
	
	protected void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	protected void setLength(double length) {
		this.length = length;
	}
	
	protected void setWidth(double width) {
		this.width = width;
	}
	
	protected void setHeight(double height) {
		this.height = height;
	}
	
	// Getters - Mutators
	protected String getName() {
		return this.name;
	}
	
	protected String getOrigin() {
		return this.origin;
	}
	
	protected String getOwner() {
		return this.owner;
	}
	
	protected String getDepartureDate() {
		return this.departuredate;
	}
	
	protected String getArrivalDate() {
		return this.arrivaldate;
	}
	
	protected int getCapacity() {
		return this.capacity;
	}
	
	protected double getLength() {
		return this.length;
	}
	
	protected double getWidth() {
		return this.width;
	}
	
	protected double getHeight() {
		return this.height;
	}
	
	// Superclass method printDetails
	public void printDetails() {
		System.out.printf("Name: %s\n", this.getName());
		System.out.printf("Origin: %s\n", this.getOrigin());
		System.out.printf("Owner: %s\n", this.getOwner());
		System.out.printf("Capacity: %d\n", this.getCapacity());
	}
	
	// Superclass method printSize
	public void printSize() {
		System.out.printf("Ship Length: %.2f\n", this.getLength());
		System.out.printf("Ship Width: %.2f\n", this.getWidth());
		System.out.printf("Ship Height: %.2f\n", this.getHeight());
	}
	
	// Superclass method printDate
	public void printDate() {
		System.out.printf("Ship Departure Date: %s\n", this.getDepartureDate());
		System.out.printf("Ship Arrival Date: %s\n", this.getArrivalDate());
	}
}

*****************************************CruiseShip.java*****************************************************

package assignment_4_exercise_2_pkg1;

public class CruiseShip extends Ship {
	
	// Declare private variables
	private double ticketprice;
	private int numberofrooms;
	private String cruisetype;
	
	// Constructor
	public CruiseShip(String name, String cruisetype, int numberofrooms, double ticketprice, String origin, String owner, int capacity, double length, double width, double height, String departuredate, String arrivaldate) {
		super(name, origin, owner, capacity, length, width, height, departuredate, arrivaldate);
		this.numberofrooms = numberofrooms;
		this.cruisetype = cruisetype;
		this.ticketprice = ticketprice;
	}
	
	// Mutators - Setters
	public void setNumberofRooms(int numberofrooms) {
		this.numberofrooms = numberofrooms;
	}
	
	public void setCruiseType(String cruisetype) {
		this.cruisetype = cruisetype;
	}
	
	public void setTicketPrice(double ticketprice) {
		this.ticketprice = ticketprice;
	}
	
	// Accessors - Getters
	public int getNumberofRooms() {
		return this.numberofrooms;
	}
	
	public String getCruiseType() {
		return this.cruisetype;
	}
	
	public double getTicketPrice() {
		return this.ticketprice;
	}
	
	// Overriden class method printDetails
	public void printDetails() {
		super.printDetails();
		System.out.printf("Cruise Type: %s\n", this.getCruiseType());
		System.out.printf("Ticket Price: %.2f\n", this.getTicketPrice());
		System.out.printf("Number of rooms: %d\n", this.getNumberofRooms());
	}
	
	// Overriden class method printSize
	public void printSize() {
		System.out.printf("Cruise Length: %.2f\n", this.getLength());
		System.out.printf("Cruise Width: %.2f\n", this.getWidth());
		System.out.printf("Cruise Height: %.2f\n", this.getHeight());
	}
	
	// Overriden class method printDate
	public void printDate() {
		System.out.printf("Cruise Departure Date: %s\n", this.getDepartureDate());
		System.out.printf("Cruise Arrival Date: %s\n", this.getArrivalDate());
	}

}

*****************************************CargoShip.java*****************************************************
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

*****************************************Driver.java*****************************************************
package assignment_4_exercise_2_pkg2;

import assignment_4_exercise_2_pkg1.*;

public class Driver {
	
	public static void main (String[] agrs) {
		
		Ship[] shipArray = new Ship[5];
		
		// Populate ship objects to array
		shipArray[0] = new CargoShip("Cargo_1", "USA", "Henry", "Cargo_Type_1", 350, 2.8, 3.6, 4.5, 500, 400, "02/22/2022", "03/22/2022");
		shipArray[1] = new CruiseShip("Cruise_1", "Cruise_Type_1", 200, 40, "Japan", "Elon Musk", 500, 5.5, 6.8, 10.2, "04/25/2022", "05/26/2022");
		shipArray[2] = new CruiseShip("Cruise_2", "Cruise_Type_2", 400, 10, "Korea", "Nathan", 500, 5.5, 6.8, 10.2, "02/25/2023", "04/25/2023");
		shipArray[3] = new CargoShip("Cargo_2", "Germany", "Buffet", "Cargo_Type_2", 200, 5, 4.4, 4.5, 690, 220, "04/08/2022", "05/09/2022");
		shipArray[4] = new CargoShip("Cargo_3", "Italia", "Federer", "Cargo_Type_3", 150, 7, 8, 9, 136, 423, "07/08/2022", "02/14/2023");
		
		// Print to the screen output
		for (int i = 0; i < shipArray.length; i++) {
			shipArray[i].printDetails();
			shipArray[i].printSize();
			shipArray[i].printDate();
			System.out.println();
		}
	}
}
