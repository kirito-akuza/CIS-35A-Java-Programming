/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 4 - Exercise 1
 * Due Date: 02/27/2022
 * Date Submitted: 02/27/2022
 */

package assignment_4_exercise_1;

public class SpecialSavings extends SavingsAccount {
	
	// Declare variable
	private double temp_interest;
	
	// Constructor
	public SpecialSavings() {
		super();
		temp_interest = 0;
	}
	
	public SpecialSavings(double balance, double interest) {
		super(balance, interest);
		temp_interest = 0;
	}
	
	// Overriden class method calculateMonthlyInterest
	public void calculateMonthlyInterest() {
		if (getSavingsBalance() > 10000) {
			temp_interest = getInterestRate();
			modifyInterestRate(10);
			super.calculateMonthlyInterest();
			modifyInterestRate(temp_interest);
		} else {
			super.calculateMonthlyInterest();
		}
	}
}
