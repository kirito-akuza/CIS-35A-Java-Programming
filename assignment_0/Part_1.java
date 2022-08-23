/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 0 - Part 1
 * Due Date: 01/12/2022
 * Date Submitted: 01/16/2022
 */
package assignment_0;

import java.util.*;

public class Part_1 {

	public static void main(String[] args) {
		// Reading from the keyboard
		Scanner in = new Scanner(System.in);

		// Declares variables to hold quantity of each item
		int tv, vcr, remote, cd, tapeRecorder;
		
		// Declares constant variable to hold unit price of each item
		final double TV = 400.00, VCR = 220, REMOTE = 35.20, CD = 300.00, TAPE = 150.00;
		
		// Declares constant variable to hold sales tax
		final double TAX_RATE = 0.0825;
		
		// Getting input data from keyboard
		System.out.print("How many TV's were sold? ");
		tv = in.nextInt();
		System.out.print("How many VCR's were sold? ");
		vcr = in.nextInt();
		System.out.print("How many remote controller's were sold? ");
		remote = in.nextInt();
		System.out.print("How many CD's were sold? ");
		cd = in.nextInt();
		System.out.print("How many Tape Recorder's were sold? ");
		tapeRecorder = in.nextInt();
		
		// Close the scanner
		in.close();
		
		// Calculate total price of each item
		double tvTotal = tv*TV;
		double vcrTotal = vcr*VCR;
		double remoteTotal = remote*REMOTE;
		double cdTotal = cd*CD;
		double tapeTotal = tapeRecorder*TAPE;
		
		// Calculate subtotal, tax, and total cost after sales tax
		double subtotal = tvTotal + vcrTotal + remoteTotal + cdTotal + tapeTotal;
		double tax = subtotal * TAX_RATE;
		double total = subtotal + tax;
		
		// Display the output
		System.out.printf("\n%-5s %-20s %-14s %-11s\n", "QTY", "DESCRIPTION", "UNIT PRICE", "TOTAL PRICE");
		System.out.printf("%-5d %-20s $%-13.2f $%-10.2f\n", tv, "TV", TV, tvTotal);
		System.out.printf("%-5d %-20s $%-13.2f $%-10.2f\n", vcr, "VCR", VCR, vcrTotal);
		System.out.printf("%-5d %-20s $%-13.2f $%-10.2f\n", remote, "Remote Controller", REMOTE, remoteTotal);
		System.out.printf("%-5d %-20s $%-13.2f $%-10.2f\n", cd, "CD Player", CD, cdTotal);
		System.out.printf("%-5d %-20s $%-13.2f $%-10.2f\n\n", tapeRecorder, "Tape Recorder", TAPE, tapeTotal);
		System.out.printf("%30s  $%-10.2f\n", "SUBTOTAL", subtotal);
		System.out.printf("%30s  $%-10.2f\n", "TAX", tax);
		System.out.printf("%30s  $%-10.2f\n", "TOTAL", total);
	}

}
