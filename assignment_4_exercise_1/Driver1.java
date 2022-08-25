/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 4 - Exercise 1
 * Due Date: 02/27/2022
 * Date Submitted: 02/27/2022
 */

package assignment_4_exercise_1;

public class Driver1 {

	public static void main(String[] args) {
		
		SavingsAccount saver1 = new SavingsAccount(2000, 4);
		SavingsAccount saver2 = new SavingsAccount(3000, 4);
		
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
			
		System.out.println();
		System.out.println("Setting annual interest rate to 5%...");
		SavingsAccount.modifyInterestRate(5);
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
			
	}

}
