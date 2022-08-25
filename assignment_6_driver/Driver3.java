/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 6
 * Due Date: 03/19/2022
 * Date Submitted: 03/19/2022
 */

package assignment_6_driver;

import java.io.IOException;
import assignment_6_adapter.SAPI;
import assignment_6_adapter.StudentAPI;

public class Driver3 {
	
	public static void main(String[] args) throws IOException {
		// Create StudentAPI object
		StudentAPI a1 = new SAPI();
		
		// Print student score with student ID and print Statistics
		a1.printStudentScore(6134);
		a1.printStatistics();
	}
	
}
