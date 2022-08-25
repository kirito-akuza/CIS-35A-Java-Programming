/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 2 - Part 1
 * Due Date: 01/31/2022
 * Date Submitted: 01/31/2022
 */

Instruction to review and run code:

*****************************************GenomeInput Class*****************************************************
1. Start the scanner to get the data from keyboard
	static Scanner in = new Scanner (System.in);

2. Create an instance method to get the input data and return HumanGenome instance
	public HumanGenome inputData () {
		
		// Declare variables
		int numberOfGenes, numberOfChromosomes, numberOfCells;
		String genomeName;
		
		// Get the Genome name, number of genes, number of Chromosomes, and number of cells
		System.out.println("Please input a Human Genome properties.");
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
3. Create Driver method
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


*****************************************HumanGenome Class*****************************************************

1. Create private variables

	private String genomeName;
	private int numberOfGenes, numberOfChromosomes, numberOfCells;

2. Create default constructor and parameterized constructor
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
	

3. Create Accessor-Getter methods
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

4. Create Mutator-Setter methods
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

5. Create Print method
	// Print method
	public void print() {
		System.out.printf("\nHuman Genome Properties.\n");
		System.out.printf("Genome Name: %s\n", getGenomeName());
		System.out.printf("Number of Genes: %d\n", getNumberOfGenes());
		System.out.printf("Number of Chromosomes: %d\n", getNumberOfChromosomes());
		System.out.printf("Number of Cells: %d\n", getNumberOfCells());
	}