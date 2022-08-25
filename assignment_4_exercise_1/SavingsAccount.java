/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 4 - Exercise 1
 * Due Date: 02/27/2022
 * Date Submitted: 02/27/2022
 */

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
