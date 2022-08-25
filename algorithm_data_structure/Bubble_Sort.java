package algorithm_data_structure;
/*
 * Bubble Sort Algorithm
 * Author: Trung Nghia Dinh
 */
public class Bubble_Sort {
	
	public static int[] bubble_sort (int[] sort) {
		int temp = 0;
		for (int i = 0; i < sort.length; i++) {
			for (int j = i + 1; j < sort.length; j++) {
				if(sort[i] > sort[j]) {
					temp = sort[j];
					sort[j] = sort[i];
					sort[i] = temp;
				}
			}
		}
		return sort;
	}
	
	public static void main(String[] args) {
		// Declares variables
		int[] array = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
		int[] newArr = bubble_sort(array);
		
		// Displays output
		System.out.println("The array after using bubble sort:");
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + " ");
		}
	}

}
