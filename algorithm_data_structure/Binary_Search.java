package algorithm_data_structure;
/*
 * Binary Search Algorithm
 * Author: Trung Nghia Dinh
 */
import java.util.*;

public class Binary_Search {

	public static int  binary_search (int[] search, int key) {

		int high = search.length - 1;
		int low = 0;
		
		while (high >= low) {
			int mid = (low + high) / 2;
			if (key > search[mid])
				low = mid + 1;
			else if (key == search[mid])
				return mid;
			else
				high = mid -1;
		}
		// Return -1 if not found
		return -1;
	}
	
	public static void main(String[] args) {
		
		// Initiates scanner
		Scanner in = new Scanner(System.in);
		
		// To use binary search, the array must be pre-sorted in increasing order
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// Getting data from keyboard
		System.out.print("Number to find: ");
		int key = in.nextInt();
		
		// Closes the scanner
		in.close();
		
		// Getting the return value
		int index = binary_search(array, key);
		if (index == -1)
			System.out.println("Not Found.");
		else
			System.out.println("The number is in the index " + index);
		
	}

}
