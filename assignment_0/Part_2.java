/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 0 - Part 2
 * Due Date: 01/12/2022
 * Date Submitted: 01/16/2022
 */
package assignment_0;

import java.util.*;

public class Part_2 {

	public static void main(String[] args) {
		
		// Declares variables to hold temperature in Centigrade and Fahrenheit
		double c_temp, f_temp;
		
		// Reading from keyboard
		Scanner in = new Scanner(System.in);
		
		// Getting temperature in Centigrade from keyboard
		System.out.print("Please enter the temperature in Centigrade: ");
		c_temp = in.nextDouble();
		
		// Formula which convert Centigrade to Fahrenheit
		f_temp = 32 + c_temp * (180.0/100.0);
		System.out.printf("The temperature in Fahrenheit: %.2f\n", f_temp);
		
		// Getting temperature in Fahrenheit from keyboard
		System.out.print("\nPlease enter the temerature in Fahrenheit: ");
		f_temp = in.nextDouble();
		
		// Formula which convert Fahrenheit to Centigrade
		c_temp = (f_temp - 32) * (100.0/180.0);
		System.out.printf("The temperature in Centigrade: %.2f\n", c_temp);
		
		// Close the scanner
		in.close();
	}

}
