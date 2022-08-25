/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 1
 * Due Date: 01/19/2022
 * Date Submitted: 01/19/2022
 */

Instruction to review and run code:
The first thing is import Scanner class by using "import java.util.*;" or "import java.util.Scanner;"

*****************************************PART 1*****************************************************
Step 1: Use the "Scanner in = new Scanner(System.in);" to get the data from keyboard
Step 2: Declares variables to hold loanAmount, annualInterestRate, monthlyInterestRate, monthlyPayment, totalPayment, interest, principal, numberOfYears, and numberOfMonths
Step 3: Getting input data and store the data into the declared variables
	For example: loanAmount = in.nextDouble(); //this one is to hold the loan amount to variable loanAmount
Step 4: After we are finished getting the data from the keyboard, we should close the scanner by using in.close();
Step 5: Calculate monthly interest rate, monthly payment, and total payment
	For example:    annualInterestRate /= 100;
			monthlyInterestRate = annualInterestRate / 12;
			numberOfMonths = numberOfYears * 12;
			monthlyPayment = (loanAmount * monthlyInterestRate * Math.pow(monthlyInterestRate + 1, numberOfMonths)) / (Math.pow(monthlyInterestRate + 1, numberOfMonths) - 1);
			totalPayment = monthlyPayment * 12;
Step 6: Calculate and display payment number, interest, principal, and balance to the screen
	For example:
			System.out.printf("\n%-15s %-15s %-15s %-15s\n", "Payment#", "Interest", "Principal", "Balance");
			for (int i = 1; i <= numberOfMonths; i++) {
				interest = monthlyInterestRate * loanAmount;
				principal = monthlyPayment - interest;
				loanAmount = loanAmount - principal;
				System.out.printf("%-15d %-15.02f %-15.02f %-15.02f\n", i, interest, principal, loanAmount);	
			}
This is a loop to display the table. The monthly payment is the same for each month so we compute it before the loop. 
The balance is initially the loan amount and for each iteration in the oop, compute the interest and principal, update the balance, and display to the screen

*****************************************PART 2*****************************************************
Step 1: Using "Scanner in = new Scanner(System.in);" to read from keyboard
Step 2: Declares variables to hold value of number, next guess, and last guess
Step 3: Getting a number from keyboard
	For example: number = in.nextDouble();
Step 4: Check if the number is positive. If the number is not valid, ask user to re-enter
	For example:	
			while(number < 0) {
				System.out.println("This is not a positive number. Please try it again.");
				System.out.print("Enter a positive number: ");
				number = in.nextLong();
			} 
Step 5: Close the scanner by using in.close();
Step 6: Call sqrt method to calculate and return the approximate value of square root number
	For example: sqrtNumber = Part_2.sqrt(number);
Step 7: Display the approximate square root of the input number
Step 8: Create the sqrt method
	For example: public static double sqrt(double n) { }
Step 9: In the sqrt method, we declares variables to hold last guess and set initial value of next guess by 1
	For example: double lastGuess, nextGuess = 1;
Step 10: In the sqrt method, we create a do while loop and repeate it until the difference between nextGuess and lastGuess is less than a very small number
	For example:
			do {
				lastGuess = nextGuess;
				// Babylonian method
				nextGuess = (lastGuess + n / lastGuess) / 2;
			} while((nextGuess - lastGuess > 0.000001) || (lastGuess - nextGuess > 0.000001));
Step 11: Returns the approximate root value
	FOr example: return nextGuess;