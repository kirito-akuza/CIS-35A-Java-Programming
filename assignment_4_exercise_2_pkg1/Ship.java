/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 4 - Exercise 2
 * Due Date: 02/27/2022
 * Date Submitted: 02/27/2022
 */

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
