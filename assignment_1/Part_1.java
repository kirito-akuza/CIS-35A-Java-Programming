/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 1 - Part 1
 * Due Date: 01/19/2022
 * Date Submitted: 01/19/2022
 */
package assignment_1;

import java.util.*;

public class Part_1 {

	public static void main(String[] args) {
		// Reading from keyboard
		Scanner in = new Scanner(System.in);
		
		// Declares variables
		double loanAmount, annualInterestRate, monthlyInterestRate, monthlyPayment, totalPayment, interest, principal;
		int numberOfYears, numberOfMonths;
		
		// Getting loan amount, number of years, and annual interest rate from keyboard
		System.out.print("Loan Amount: ");
		loanAmount = in.nextDouble();
		System.out.print("Number of Years: ");
		numberOfYears = in.nextInt();
		System.out.print("Anual Interest Rate: ");
		annualInterestRate = in.nextDouble();
		
		// Close the scanner
		in.close();
		
		// Calculate monthly interest rate, monthly payment, and total payment
		annualInterestRate /= 100;
		monthlyInterestRate = annualInterestRate / 12;
		numberOfMonths = numberOfYears * 12;
		monthlyPayment = (loanAmount * monthlyInterestRate * Math.pow(monthlyInterestRate + 1, numberOfMonths)) / (Math.pow(monthlyInterestRate + 1, numberOfMonths) - 1);
		totalPayment = monthlyPayment * 12;
		
		// Display monthly payment, total payment to the screen
		System.out.printf("\nMonthly Payment: %.2f\n", monthlyPayment);
		System.out.printf("Total Payment: %.2f\n", totalPayment);
		
		// Calculate and display payment number, interest, principal, and balance to the screen
		System.out.printf("\n%-15s %-15s %-15s %-15s\n", "Payment#", "Interest", "Principal", "Balance");
		for (int i = 1; i <= numberOfMonths; i++) {
			interest = monthlyInterestRate * loanAmount;
			principal = monthlyPayment - interest;
			loanAmount = loanAmount - principal;
			System.out.printf("%-15d %-15.02f %-15.02f %-15.02f\n", i, interest, principal, loanAmount);	
		}
	}

}
