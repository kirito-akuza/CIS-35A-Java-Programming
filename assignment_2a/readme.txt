/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 1
 * Due Date: 01/27/2022
 * Date Submitted: 01/27/2022
 */

Instruction to review and run code:

*****************************************PART 1*****************************************************
1. In function "public static int BinaryToDecimal(int binaryNumber) {} "

Step 1: // Declares variables
	int decimal = 0, count = 0;
	int[] array = new int [50];
"decimal" will hold the number in decimal after calculating number in binary
"count" will store number of digits
The array "array[]" will store every digits of binary number

Step 2: // Stores every digit into array
	while(binaryNumber != 0) {
		array[count] = binaryNumber % 10;
		binaryNumber /= 10;
		count++;
	}
Step 3: // Calculating the decimal number and return the value
	for (int i = 0; i < count; i++) {
		decimal += array[i] * Math.pow(2, i);
	}
	return decimal;

2. In function "public static String DecimalToBinary(int decimalNumber) {} "

Step 1: //Declares variables
	String binary = "";
	int[] binaryNum = new int[50];
	int count = 0;
"binary" will store the binary number and return this value
"[] binaryNum" will store every digits of binary number after calculating in array
"count" will store number of digits

Step 2: // Calculating the binary number
	while(decimalNumber != 0) {
		binaryNum[count] = decimalNumber % 2;
		decimalNumber /= 2;
		count++;
	}

Step 3: // Getting the binary number and return the value
	for (int i = count - 1; i >= 0; i--) {
		binary += binaryNum[i];
	}
	return binary;

3. In main function:
	// Display the output to the screen by calling the two function above
	System.out.println("1001011B = " + BinaryToDecimal(1001011) + "D");
	System.out.println("1101110D = " + DecimalToBinary(1101110) + "B");

*****************************************PART 2*****************************************************

"Demonstrate the program by setting the values of student's answers in main
(You are not required to prompt the user to enter values using Scanner or System.in.read()), 
and then display the result returned from the methods written in the program."

Because we are not required to prompt the user to enter values so we set the student's answer in main by anything

1. In main function

Step 1: // Declares correct answers and student's answers
	char[] correctAns = {'B', 'D', 'A', 'A', 'C', 'D', 'A', 'B', 'C', 'A', 'B', 'C', 'D', 'A', 'B'};
	char[] studentAns = {'A', 'A', 'B', 'B', 'A', 'A', 'D', 'D', 'B', 'B', 'D', 'D', 'C', 'C', 'C'};
		
Step 2: // Declares an array get the return of questions numbers of the questions that the student missed
	int[] missed = new int[totalIncorrect(correctAns, studentAns)];
	missed = questionNumbersMissed(correctAns, studentAns);
		
Step 3: // Calling passed() function to check for student status. Return true/false and display number of correct and incorrect answers
	if (passed(correctAns, studentAns))
		System.out.println("Passed! Correct: " + totalCorrect(correctAns, studentAns) + ". Incorrect: " + totalIncorrect(correctAns, studentAns));
	else if (!passed(correctAns, studentAns))
		System.out.println("Failed! Correct: " + totalCorrect(correctAns, studentAns) + ". Incorrect: " + totalIncorrect(correctAns, studentAns));
		
Step 4: // Displays the questions numbers of the questions that the student missed
	System.out.print("Student missed the question: ");
	for (int i = 0; i < totalIncorrect(correctAns, studentAns); i++) {
		System.out.print(missed[i] + " ");
	}

2. In function "public static int totalCorrect (char[] correct, char[] student) { }"

Step 1: // Declares a variable to hold the number of correct answers
	int count = 0;
	
Step 2: // Variable count will increase 1 if a correct answer same as a student answer and then return the number of correctly answered
	for (int i = 0; i < correct.length; i++) {
		if (correct[i] == student[i])
			count ++;
	}
	return count;

3. In function "public static boolean passed (char[] correct, char[] student) {} "
		
	// Calling function totalCorrect() to get the return of the number of correct answers
	// Students will pass if they have the correct answers more than 12
	if (totalCorrect(correct, student) >= 12)
		return true;
	else
		return false;

4. In function "public static int totalIncorrect (char[] correct, char[] student) {} "
	// Calling function totalCorrect() to get the number of correctly answered and then return the number of incorrectly answered
	return 15 - totalCorrect(correct, student);
	
5. In function "public static int[] questionNumbersMissed (char[] correct, char[] student) {}"

Step 1: // Declares an array containing the questions numbers of the questions that the student missed.
		int[] missedAns = new int[15];
		int index = 0;
		
Step 2: // Using loop to find incorrectly answered and store it in the declared array above. Return the missedAns array after looping
	for (int i = 0; i < correct.length; i++) {
		if (correct[i] != student[i]) {
			missedAns[index] = i + 1;
			index++;
		}
	}
	return missedAns;


*****************************************PART 3*****************************************************

1. In main function

Step 1:	// Reading from keyboard
	Scanner in = new Scanner(System.in);
		
Step 2: // Declares an array to hold a list of the sales figures by 6 division in 4 quarter
	double[][] sales = new double[6][4];
		
Step 3: // Getting sales data from keyboard
	System.out.println("Please input sales data of 6 divisions in 4 quarters");
	for (int i = 0; i < 6; i++) {
		for (int k = 0; k < 4; k++) {
			System.out.print("Division " + (i + 1) + ", quarter " + (k + 1) + ": ");
	
			// Getting sales from keyboard and hold it in sales[i][k] array
			sales[i][k] = in.nextDouble();
			
			// Checking input validation: Do not accept negative numbers for sales figures.
			while (sales[i][k] < 0) {
				System.out.println("Please input positive number.");
				System.out.print("Division " + (i + 1) + ", quarter " + (k + 1) + ": ");
				sales[i][k] = in.nextDouble();
			}
		}
	}
		
Step 4: // Close the scanner
	in.close();
		
Step 5: // Calling function printSales() to print the table of total sales
	printSales(sales);
		
Step 6: // Calling function printDivChanges() to print the table of each division increases or decreases from the previous quarter
	printDivChanges(sales);
		
Step 7:	// Calling function printTotalSales() to print the total sales for the quarter 
	printTotalSales(sales);
		
Step 8: // Calling function printComChanges() to print the company's increase or decrease from the previous quarter
	printComChanges(sales);
		
Step 9:	// Calling function printAvgSales() to print the average sales for all divisions that quarter
	printAvgSales(sales);
		
Step 10: // Calling function printHighestDiv() to print the division with the highest sales for that quarter
	 printHighestDiv(sales);

2. In function "public static void printSales (double[][] sales) {} "	
	System.out.println("\nTable of all Sales");
	System.out.printf("\n%-14s%-13s%-13s%-13s%-13s\n", "Divison", "Quater 1", "Quarter 2", "Quarter 3", "Quarter 4");
	
	// Printing the table of all Sales
	for (int i = 0; i < 6; i++) {
		System.out.printf("Division %-5d", i + 1);
		for (int k = 0; k < 4; k++) {
			System.out.printf("%-13.2f", sales[i][k]);
		}
		System.out.println();
	}
3. In function "public static void printTotalSales(double[][] sales) {}"

	System.out.println("\nTotal Sales for each quarter");
			
	// Calculating the total sales each quarter 
	for (int i = 0; i < 4; i++) {
		double totalSales = 0;
		for (int k = 0; k < 6; k++) {
			totalSales += sales[k][i];
		}
		
		//Printing the total sales each quarter 
		System.out.println("Total Sales Quarter " + (i + 1) + ": " + totalSales);
	}

4. In function "public static void printDivChanges (double[][] sales) {}"
	System.out.println("\nIncrease or Decrease from the previous quarter each division");
	System.out.printf("\n%-14s%-13s%-13s%-13s\n", "Divison", "Quarter 2", "Quarter 3", "Quarter 4");
	for(int i = 0; i < 6; i++) {
		System.out.printf("Division %-5d", i + 1);
		for(int k = 1; k < 4; k++) {
			
			// Checking if the sales of the next quarter is greater than the last quarter then prints "Increase". Otherwise, prints "Decrease"
			if(sales[i][k] > sales[i][k-1])
				System.out.printf("%-13s", "Increase");
			else 
				System.out.printf("%-13s", "Decrease");
		}
		System.out.println();
	}

5. In function "public static void printComChanges(double[][] sales) {}"
	// Declares an array to hold the total sales each quarter
	double[] totalSales = new double[4];
	System.out.println("\nIncrease or Decrease of Company from previous quarter");
	System.out.printf("%-14s%-13s%-13s%-13s\n", "", "Quarter 2", "Quarter 3", "Quarter 4");
	System.out.printf("%-14s", "Company");
	
	// Calculating the total sale each quarter and hold it in the totalSales[] array 
	for (int i = 0; i < 4; i++) {
		double total = 0;
		for (int k = 0; k < 6; k++) {
			total += sales[k][i];
		}
		totalSales[i] = total;
	}
	
	// Comparing the total sales of the next quarter with the last quarter
	// If the total sales of the next quarter is greater than the las quarter, then prints "Increase". Otherwise, prints "Decrease"
	for (int i = 1; i < 4; i++) {
		if (totalSales[i] > totalSales[i-1])
			System.out.printf("%-13s", "Increase");
		else 
			System.out.printf("%-13s", "Decrease");
	}
	System.out.println();

6. In function "public static void printAvgSales(double[][] sales) {}"
	System.out.println("\nAverage Sales for each quarter");
		
	// Calculating the total sales each quarter
	for (int i = 0; i < 4; i++) {
		double totalSales = 0;
		for (int k = 0; k < 6; k++) {
			totalSales += sales[k][i];
		}
		
		// Displays the average sales each quarter by let totalSales/6
		System.out.printf("Average Sales Quarter %d: %.2f\n", (i + 1), totalSales/6);
	}

7. In function "public static void printHighestDiv(double[][] sales) {}"
	// Declares variables
	double max = 0;
	int index = 0;
	System.out.println("\nHighest Sales in each quarter");
	// Comparing and find the max sales value in each quarter and its index in array
	for (int i = 0; i < 4; i++) {
		max = sales[i][0];
		for (int k = 0; k < 6; k++) {
			if (max < sales[k][i]) {
				max = sales[k][i];
				index = k;
			}
		}
		// Displays which division has the greatest sales in each quarter
		System.out.println("Quarter " + (i + 1) + ": Division " + (index + 1) + " with sales of " + max);
	}