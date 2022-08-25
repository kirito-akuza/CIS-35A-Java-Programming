/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 4 - Exercise 2
 * Due Date: 02/27/2022
 * Date Submitted: 02/27/2022
 */

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
