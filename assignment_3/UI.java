/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 3
 * Due Date: 02/14/2022
 * Date Submitted: 02/14/2022
 */

package assignment_3;

import java.util.Scanner;

public class UI {
	// Get data from keyboard
	Scanner in = new Scanner(System.in);
	
	// Declare variable
	private Franchise f;
	
	// Constructor
	public UI(Franchise f) {
		this.f = f;
	}
	
	public void play() {
		// Declare variables
		boolean flag = true;
		boolean checkInput = true;
		char key;
		
		System.out.println("Welcome to Franchise App");
		System.out.println("We have data for 6 stores for last 5 weeks.");
		// If flag == true -> keep looping
		while (flag) {
			// If checkInput == true -> runUI() to ask and get data from user
			if (checkInput)
				runUI();
			// Ask user if he/she wants to continue to use the app
			System.out.print("Do you want to continue? - enter <y/n>: ");
			key = in.next().charAt(0);
			
			// If user enters any character that invalid -> asks user to enter again
			if(key == 'y' || key =='Y') {
				checkInput = true;
			} else if (key == 'n' || key == 'N') {
				// If user enter 'n' or 'N' -> exit the loop
				flag = false;
			} else {
				System.out.println("Invalid input. Please try it again.");
				checkInput = false;
			}
		}
		// If user enters 'n' or 'N' -> exit the loop and say goodbye
		System.out.println("\nThank you! Have a nice day!");	
	}
	
	void runUI() {
		// Declares variables
		int i, k;
		
		// Get user's input the store's number
		System.out.print("Select a store # you want to see analytics for - enter <1 through 6>: ");
		i = in.nextInt();
		
		// If user enters a number out of range from 1 to 6 -> Asks user to retry
		while (i > 6 || i < 1) {
			System.out.println("Store invalid.");
			System.out.println("Please try it again.");
			System.out.print("\nSelect a store # you want to see analytics for - enter <1 through 6>: ");
			i = in.nextInt();
		}
		
		// Asks user to select operation for a store
		System.out.printf("\nAcessing data from store %d ...\n", i);
		System.out.println("Select operation - ");
		System.out.println("1. Enter 1 for total sales for each week");
		System.out.println("2. Enter 2 for average daily sales for each week");
		System.out.println("3. Enter 3 for total sales for all weeks");
		System.out.println("4. Enter 4 for average weekly sales");
		System.out.println("5. Enter 5 for week with the highest amount in sales.");
		System.out.println("6. Enter 6 for week with the lowest amount in sales.");
		System.out.println("7. Enter 7 for all analytical data. (1 through 6)");
		System.out.println("8. Enter 8 for table of sales data");
		System.out.print("Enter <1 through 8>: ");
		k = in.nextInt();
		
		// If users enter a number out of range from 1 to 8 -> ask user to retry
		while (k < 1 || k > 8) {
			System.out.println("Invalid operation");
			System.out.println("Please try it again.");
			System.out.println("\nSelect operation - ");
			System.out.println("1. Enter 1 for total sales for each week");
			System.out.println("2. Enter 2 for average daily sales for each week");
			System.out.println("3. Enter 3 for total sales for all weeks");
			System.out.println("4. Enter 4 for average weekly sales");
			System.out.println("5. Enter 5 for week with the highest amount in sales.");
			System.out.println("6. Enter 6 for week with the lowest amount in sales.");
			System.out.println("7. Enter 7 for all analytical data. (1 through 6)");
			System.out.println("8. Enter 8 for table of sales data");
			System.out.print("Enter <1 through 8>: ");
			k = in.nextInt();
		}
		
		// Print out to the screen
		System.out.println();
		f.getStores(i-1).print(k);
	}
}
