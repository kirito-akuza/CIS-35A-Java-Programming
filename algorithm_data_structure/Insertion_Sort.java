package algorithm_data_structure;
/*
 * Insertion Sort Algorithm
 * Author: Trung Nghia Dinh
 */
public class Insertion_Sort {
	
	public static int[] insertion_sort (int[] sort) {
		
		for (int i = 1; i < sort.length; i++) {
			int currentElement = sort[i];
			int k;
			for (k = i - 1; k >= 0 && sort[k] > currentElement; k--) {
				sort[k + 1] = sort[k];
			}
			sort[k + 1] = currentElement;
		}
		return sort;
	}
	
	public static void main(String[] args) {
		
		// Declares variables
		int[] array = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
		int[] newArr = insertion_sort(array);
		
		// Displays output
		System.out.println("The array after using insertion sort:");
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + " ");

		}

	}
}
