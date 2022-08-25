package algorithm_data_structure;
/*
 * Selection Sort Algorithm
 * Author: Trung Nghia Dinh
 */
public class Selection_Sort {
	
	public static int[] selection_sort (int[] sort) {
		
		for (int i = 0; i < sort.length; i++) {
			// Declares variables
			int min = sort[i];
			int index = i;
			
			// Find the minimum in the sort[]
			for (int j = i + 1; j < sort.length; j++) {
				if (min > sort[j]) {
					index = j;
					min = sort[j];
				}
			}
			
			// Swap sort[i] with sort[index]
			if (index != i) {
				sort[index] = sort[i];
				sort[i] = min;
			}
		}
		return sort;
	}
	
	public static void main(String[] args) {
		
		int[] array = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
		int[] newArr = selection_sort(array);
		
		System.out.println("The array after using selection sort:");
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + " ");
		}

	}

}
