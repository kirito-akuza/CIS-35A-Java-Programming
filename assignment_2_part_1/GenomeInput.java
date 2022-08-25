/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 2 - Part 1
 * Due Date: 01/31/2022
 * Date Submitted: 01/31/2022
 */

package assignment_2_part_1;

import java.util.*;

public class GenomeInput {
	
	// Reading from keyboard
	static Scanner in = new Scanner (System.in);

	public HumanGenome inputData () {
		
		// Declare variables
		int numberOfGenes, numberOfChromosomes, numberOfCells;
		String genomeName;
		
		// Get the Genome name, number of genes, number of Chromosomes, and number of cells
		System.out.println("Please input a Human Genome properties");
		System.out.print("Genome Name: ");
		genomeName = in.nextLine();
		System.out.print("Number of Genes: ");
		numberOfGenes = in.nextInt();
		System.out.print("Number of Chromosomes: ");
		numberOfChromosomes = in.nextInt();
		System.out.print("Number of Cells (Trillions): ");
		numberOfCells = in.nextInt();
		
		// Clear new line
		in.nextLine();
		System.out.println();
		
		// Create instance of HumanGenome
		HumanGenome properties = new HumanGenome(genomeName, numberOfGenes, numberOfChromosomes, numberOfCells);
		
		return properties;
	}
	
	// Driver method
	public static void main(String[] args) {
		
		// Create instances of HumanGenome
		GenomeInput value = new GenomeInput();
		HumanGenome Aladdin = value.inputData();
		
		value = new GenomeInput();
		HumanGenome Arthur = value.inputData();
		
		value = new GenomeInput();
		HumanGenome Elsa = value.inputData();
		
		// Print instances of HumanGenome
		Aladdin.print();
		Arthur.print();
		Elsa.print();
	}
}
