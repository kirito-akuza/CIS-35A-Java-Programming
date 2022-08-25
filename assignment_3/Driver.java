/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 3
 * Due Date: 02/14/2022
 * Date Submitted: 02/14/2022
 */

package assignment_3;

public class Driver {

	public static void main(String[] args) {
		// Create instance and object of FileIO
		FileIO a1 = new FileIO("C:\\Users\\Nathan Dinh\\eclipse-workspace\\CIS_35A\\src\\assignment_3\\Salesdat.txt");
		// Read data from file
		Franchise f = a1.readData();
		// Do calculation for all stores by calling method calc()
		f.calc();
		
		// Get ready and Run UI
		UI ui = new UI(f);
		ui.play();
	}

}
