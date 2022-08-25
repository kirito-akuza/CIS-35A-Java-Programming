/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 4 - Exercise 2
 * Due Date: 02/27/2022
 * Date Submitted: 02/27/2022
 */

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
