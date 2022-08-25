/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 2 - Part 1
 * Due Date: 01/31/2022
 * Date Submitted: 01/31/2022
 */

package assignment_2_part_1;

public class HumanGenome {
	
	// Declare private variables
	private String genomeName;
	private int numberOfGenes, numberOfChromosomes, numberOfCells;
	
	// Default Constructor
	public HumanGenome() {
		genomeName = null;
		numberOfGenes = 0;
		numberOfChromosomes = 0;
		numberOfCells = 0;
	}
	
	// Parameterized Constructor
	public HumanGenome(String genomeName, int numberOfGenes, int numberOfChromosomes, int numberOfCells) {
		this.genomeName = genomeName;
		this.numberOfGenes = numberOfGenes;
		this.numberOfChromosomes = numberOfChromosomes;
		this.numberOfCells = numberOfCells;	
	}
	
	// Accessor - Getter methods
	public String getGenomeName() {
		return genomeName;
	}
	
	public int getNumberOfGenes() {
		return numberOfGenes;
	}
	
	public int getNumberOfChromosomes() {
		return numberOfChromosomes;
	}
	
	public int getNumberOfCells() {
		return numberOfCells;
	}
	
	// Mutators - Setters
	public void setGenomeName(String name) {
		genomeName = name;
	}
	
	public void setNumberOfGenes(int genes) {
		numberOfGenes = genes;
	}
	
	public void setNumberOfChromosomes(int chromosomes) {
		numberOfChromosomes = chromosomes;
	}
	public void setNumberOfCells(int cells) {
		numberOfCells = cells;
	}
	
	// Print method
	public void print() {
		System.out.printf("\nHuman Genome Properties\n");
		System.out.printf("Genome Name: %s\n", getGenomeName());
		System.out.printf("Number of Genes: %d\n", getNumberOfGenes());
		System.out.printf("Number of Chromosomes: %d\n", getNumberOfChromosomes());
		System.out.printf("Number of Cells (Trillions): %d\n", getNumberOfCells());
	}
}
