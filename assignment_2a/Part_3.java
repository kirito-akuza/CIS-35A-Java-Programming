/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 2a - Part 3
 * Due Date: 01/27/2022
 * Date Submitted: 01/27/2022
 */

package assignment_2a;

import java.util.*;

public class Part_3 {
	
	public static void printSales (double[][] sales) {
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
	}
	
	public static void printTotalSales(double[][] sales) {
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
	}
	
	public static void printDivChanges (double[][] sales) {
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
	}
	
	public static void printComChanges(double[][] sales) {
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
	}
	
	public static void printAvgSales(double[][] sales) {
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
	}
	
	public static void printHighestDiv(double[][] sales) {
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
	}
	
	public static void main (String[] args) {
		// Reading from keyboard
		Scanner in = new Scanner(System.in);
		
		// Declares an array to hold a list of the sales figures by 6 division in 4 quarter
		double[][] sales = new double[6][4];
		
		// Getting sales data from keyboard
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
		
		// Close the scanner
		in.close();
		
		// Calling function printSales() to print the table of total sales
		printSales(sales);
		
		// Calling function printDivChanges() to print the table of each division increases or decreases from the previous quarter
		printDivChanges(sales);
		
		// Calling function printTotalSales() to print the total sales for the quarter 
		printTotalSales(sales);
		
		// Calling function printComChanges() to print the company's increase or decrease from the previous quarter
		printComChanges(sales);
		
		// Calling function printAvgSales() to print the average sales for all divisions that quarter
		printAvgSales(sales);
		
		// Calling function printHighestDiv() to print the division with the highest sales for that quarter
		printHighestDiv(sales);
	}
}
