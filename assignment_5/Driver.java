/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 5
 * Due Date: 03/07/2022
 * Date Submitted: 03/07/2022
 */

package assignment_5;

import java.util.*;

public class Driver {
	// Get data from keyboard
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// Declare Variables
		boolean flag = true;
		boolean checkInput = true;
		char key;
		
		// Create array of 40 students
		Student[] myStudent = new Student[40];
		
		// Update myStudent array after reading a file
		myStudent = FileIO.ReadFile("C:\\Users\\Nathan Dinh\\eclipse-workspace\\CIS_35A\\src\\assignment_5\\student_data.txt", myStudent);
		
		// Create instance of Statistical
		Statistics statlab5 = new Statistics();
		statlab5.findlow(myStudent);
		statlab5.findhigh(myStudent);
		statlab5.findavg(myStudent);
		
		// Display User Interface
		System.out.println("Welcome to Statistical Analysis of Scores Application");
		System.out.println("We have data of 5 quizzes from students");
		
		// Check if user want to continue or not
		while (flag) {
			// If key input is invalid -> runUI will not run
			if(checkInput)
				runUI(statlab5);
			
			// Ask user to continue or not
			System.out.print("Do you want to continue? - enter <y/n>: ");
			key = in.next().charAt(0);
			
			// If key is 'y' or 'Y' -> Run UI
			if(key == 'y' || key == 'Y')
				checkInput = true;
			// If key is 'n' or 'N' -> Exit application
			else if (key == 'n' || key =='N')
				flag = false;
			// If key is invalid -> ask user again
			else {
				System.out.println("Invalid Input. Please try it again.");
				checkInput = false;
			}
		}
		// Exiting greeting
		System.out.println("\nThank you! Have a nice day!");	
	}
	
	static void runUI(Statistics statlab5) {
		// Display operation user interface
		System.out.println("Select operation - ");
		System.out.println("1. Enter 1 for printing low scores.");
		System.out.println("2. Enter 2 for printing high scores.");
		System.out.println("3. Enter 3 for printing average scores.");
		System.out.println("4. Enter 4 for printing all statistical data.");
		System.out.print("Enter <1 through 4>: ");
		int i = in.nextInt();
		System.out.println();
		
		// Check if user enters valid number
		while (i < 1 || i > 4) {
			System.out.println("Invalid Input. Please try it again.");
			System.out.println("Select operation - ");
			System.out.println("1. Enter 1 for printing low scores.");
			System.out.println("2. Enter 2 for printing high scores.");
			System.out.println("3. Enter 3 for printing average scores.");
			System.out.println("4. Enter 4 for printing all statistical data.");
			System.out.print("Enter <1 through 4>: ");
			i = in.nextInt();
			System.out.println();
		}
		
		// Displays data
		statlab5.print(i);
	}
}
