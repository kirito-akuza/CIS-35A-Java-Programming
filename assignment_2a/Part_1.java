/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 2a - Part 1
 * Due Date: 01/27/2022
 * Date Submitted: 01/27/2022
 */

package assignment_2a;

public class Part_1 {
	
	public static int BinaryToDecimal(int binaryNumber) {
		// Declares variables
		int decimal = 0;
		int count = 0;
		int[] array = new int[50];
		
		// Stores every digit into array
		while(binaryNumber != 0) {
			array[count] = binaryNumber % 10;
			binaryNumber /= 10;
			count++;
		}
		
		// Calculating the decimal number
		for (int i = 0; i < count; i++) {
			decimal += array[i] * Math.pow(2, i);
		}
		
		return decimal;
	}
	
	public static String DecimalToBinary(int decimalNumber) {
		// Declares variables
		String binary = "";
		int[] binaryNum = new int[50];
		int count = 0;
		
		// Calculating the binary number
		while(decimalNumber != 0) {
			binaryNum[count] = decimalNumber % 2;
			decimalNumber /= 2;
			count++;
		}
		
		// Getting the binary number
		for (int i = count - 1; i >= 0; i--) {
			binary += binaryNum[i];
		}
		
		return binary;
	}
	
	public static void main(String[] args) {
		// Display the output to the screen 
		System.out.println("1001011B = " + BinaryToDecimal(1001011) + "D");
		System.out.println("1101110D = " + DecimalToBinary(1101110) + "B");
	}
	
}
