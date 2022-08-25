/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 1 - Part 2
 * Due Date: 01/19/2022
 * Date Submitted: 01/19/2022
 */
package assignment_1;

import java.util.*;

public class Part_2 {
	
	public static void main(String[] args) {
		// Reading from keyboard
		Scanner in = new Scanner(System.in);
		
		// Declares variables to hold value of number, next guess, and last guess
		double number, sqrtNumber;
		
		// Getting a number from keyboard
		System.out.print("Enter a positive number: ");
		number = in.nextDouble();
		
		// Check if the number is positive
		while(number < 0) {
			System.out.println("This is not a positive number. Please try it again.");
			System.out.print("Enter a positive number: ");
			number = in.nextLong();
		}
		
		// Close the scanner
		in.close();
		
		// Call sqrt method to return the approximate value of square root number
		sqrtNumber = Part_2.sqrt(number);
		
		// Display the approximate square root of the input number
		System.out.printf("The approximate square root is %.5f\n", sqrtNumber);
	}
	
	public static double sqrt(double n) {
		// Declares variable to hold value of last guess and set initial value of next guess by 1
		double lastGuess, nextGuess = 1;
		
		// Loop until the difference between nextGuess and lastGuess is less than a very small number
		do {
			lastGuess = nextGuess;
			// Babylonian method
			nextGuess = (lastGuess + n / lastGuess) / 2;
		} while((nextGuess - lastGuess > 0.000001) || (lastGuess - nextGuess > 0.000001));
		// Returns the approximate root vaue
		return nextGuess;
	}
}
