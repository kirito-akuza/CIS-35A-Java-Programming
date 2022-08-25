/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 4 - Exercise 1
 * Due Date: 02/27/2022
 * Date Submitted: 02/27/2022
 */

Instruction to review and run code:

*****************************************SavingsAccount.java*****************************************************
package assignment_4_exercise_1;

public class SavingsAccount {
	
	// Declare variables
	private static double annualInterestRate;
	private double savingsBalance;
	
	// Constructors
	public SavingsAccount() {
		annualInterestRate = 0;
		savingsBalance = 0;		
	}
	
	public SavingsAccount(double balance, double interest) {
		this.savingsBalance = balance;
		annualInterestRate = interest;
	}
	
	// Superclass of method of calculateMonthlyInterest
	public void calculateMonthlyInterest() {
		this.savingsBalance += this.savingsBalance * (annualInterestRate / 100) / 12;
		print();
	}
	
	// method to modigy interest rate
	protected static void modifyInterestRate(double newValue) {
		annualInterestRate = newValue;
	}
	
	// method of setting balance
	protected void setBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	// method of get monthly interest rate
	public double getMonthlyInterestRate() {
		return (savingsBalance * (annualInterestRate / 100) / 12);
	}
	
	// method of getting interest rate
	protected static double getInterestRate() {
		return annualInterestRate;
	}
	
	// method of getting saving balance
	protected double getSavingsBalance() {
		return this.savingsBalance;
	}
	
	// print method
	public void print() {
		System.out.printf("New Balance: $%.2f, Interest rate: %.2f%%\n", this.savingsBalance, annualInterestRate);
	}
	
	// method of deposit
	public void Deposit(double money) {
		this.savingsBalance += money;
	}
	
	// method of withdrawal
	public void Withdrawal(double money) {
		if (getSavingsBalance() < money) 
			System.out.printf("You don't have enough balance. Please deposit at least %.2f\n", money - getSavingsBalance());
		else 
			this.savingsBalance -= money;
	}
}

*****************************************SpecialSavings.java*****************************************************

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

*****************************************Driver1.java*****************************************************
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

*****************************************Driver2.java*****************************************************
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
