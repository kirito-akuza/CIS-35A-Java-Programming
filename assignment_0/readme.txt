/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 0
 * Due Date: 01/12/2022
 * Date Submitted: 01/16/2022
 */

Instruction to review and run code:
The first thing is import Scanner class by using "import java.util.*;" or "import java.util.Scanner;"

*****************************************PART 1*****************************************************
Step 1: Use the "Scanner in = new Scanner(System.in);" to get the data from keyboard
Step 2: Declares variables to hold quantity of each item
	Declares constant variables to hold each unit price
	Declares constant variable to hold the sales tax value
Step 3: Getting input data and store the data into the declared variables
	(for example: tv = in.NextInt(); //this one is to hold the number of TV)
Step 4: After we are done getting the data from the keyboard, we should close the scanner by using in.close();
Step 5: We calculate total price of each item by using the quantity multiply with the unit price and store in a new variable
	(for example: double tvTotal = tv * TV;)
Step 6: Calculate subtotal, tax, abd total cost after sales tax
	Subtotal is equal to the sum of all total price of each item
	Tax is equal to subtotal multiply with sales tax
	Total is equal to sum of subtotal and tax
Step 7: Display the output using System.out.printf(null, args);
	(for example: System.out.printf("%-5d %-20s $%-13.2f $%-10.2f\n", tv, "TV", TV, tvTotal);
	The %-5d which means that the width is 5 and the text is written from left side)

*****************************************PART 2*****************************************************
Step 1: Declares variables to hold temperature in Centigrade and Fahrenheit
Step 2: Using "Scanner in = new Scanner(System.in);" to read from keyboard
Step 3: Getting temperature in Centigrade from keyboard
	(for example: c_temp = in.nextDouble();)
Step 4: Calculate Fahrenheit temperature of the Centigrade temperature getting from the keyboard
	(for example: f_temp = 32 + c_temp * (180.0/100.0);)
Step 5: Display the Fahrenheit temperature
	(For example: System.out.printf("The temperature in Fahrenheit: %.2f\n", f_temp);
	The ".2f" means that we only get precision of 2)
Step 6: Getting temperature in Fahrenheit from keyboard
	(for example: f_temp = in.nextDouble();)
Step 7: Calculate Centigrade temperature of the Fahrenheit temperature getting from the keyboard
	(for example: c_temp = (f_temp - 32) * (100.0/180.0);)
Step 8: Display the Centigrade temperature
	(for example: System.out.printf("The temperature in Centigrade: %.2f\n", c_temp);)
Step 9: Close the scanner by using in.close();