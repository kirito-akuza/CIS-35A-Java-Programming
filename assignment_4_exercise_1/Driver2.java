/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 4 - Exercise 1
 * Due Date: 02/27/2022
 * Date Submitted: 02/27/2022
 */

package assignment_4_exercise_1;

public class Driver2 {

	public static void main(String[] args) {

		SavingsAccount saver1 = new SpecialSavings(2000, 4);
		SavingsAccount saver2 = new SpecialSavings(3000, 4);
		
		// when overriden to calculate monthly interest, there is a print function to print data to the screen
		saver1.Deposit(9000);
		saver1.calculateMonthlyInterest();
		
		saver1.Withdrawal(2000);
		saver1.calculateMonthlyInterest();
		
		// Testing for saver2
		saver2.Deposit(2000);
		saver2.calculateMonthlyInterest();
		
		saver2.Withdrawal(3000);
		saver2.calculateMonthlyInterest();
		
		saver2.Deposit(10000);
		saver2.calculateMonthlyInterest();
		
		saver2.Withdrawal(10000);
		saver2.calculateMonthlyInterest();
	}
}
