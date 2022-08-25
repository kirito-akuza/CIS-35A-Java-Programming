/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 2 - Part 2
 * Due Date: 01/31/2022
 * Date Submitted: 01/31/2022
 */

Instruction to review and run code:

*****************************************GenoNucleicAcid Class*****************************************************
1. Start the scanner to get the data from keyboard
	static Scanner in = new Scanner (System.in);

2. Create an instance method to get the input data and return NucleicAcid instance
	
	public NucleicAcid inputData() {
		// Declares variables
		String name, chemicalFormula;
		float molarMass;
		float density;
		
		// Get name, chemical formula, molar mass, and density from keyboard
		System.out.println("Please input a Nucleic Acid properties.");
		System.out.print("Name: ");
		name = in.nextLine();
		System.out.print("Chemical Formula: ");
		chemicalFormula = in.nextLine();
		System.out.print("Molar Mass: ");
		molarMass = in.nextFloat();
		System.out.print("Density: ");
		density = in.nextFloat();
		
		// Clear new line
		in.nextLine();
		System.out.println();
		
		// Create instance of NucleicAcid
		NucleicAcid properties = new NucleicAcid(name, chemicalFormula, molarMass, density);
		
		return properties;
	}

3. Create Driver method

	public static void main(String[] args) {
		
		// Create instances of NucleicAcid
		GenoNucleicAcid value = new GenoNucleicAcid();
		NucleicAcid cytosine = value.inputData();
		
		value = new GenoNucleicAcid();
		NucleicAcid adenine = value.inputData();
		
		value = new GenoNucleicAcid();
		NucleicAcid guanine = value.inputData();
		
		value = new GenoNucleicAcid();
		NucleicAcid thymine = value.inputData();
		
		value = new GenoNucleicAcid();
		NucleicAcid uracil = value.inputData();
		
		// Print instances of NucleicAcid
		cytosine.print();
		adenine.print();
		guanine.print();
		thymine.print();
		uracil.print();
	}


*****************************************NucleicAcid Class*****************************************************

1. Create private variables

	private String name, chemicalFormula;
	private float molarMass, density;

2. Create default constructor and parameterized constructor
	
	// Default Constructor
	public NucleicAcid() {
		name = null;
		chemicalFormula = null;
		molarMass = 0;
		density = 0;
	}
	
	// Parameterized constructor
	public NucleicAcid(String name, String chemicalFormula, float molarMass, float density) {
		this.name = name;
		this.chemicalFormula = chemicalFormula;
		this.molarMass = molarMass;
		this.density = density;	
	}
	

3. Create Accessor-Getter methods	
	
	public String getName() {
		return name;
	}
	
	public String getChemicalFormula() {
		return chemicalFormula;
	}
	
	public float getMolarMass() {
		return molarMass;
	}
	
	public float getDensity() {
		return density;
	}

4. Create Mutator-Setter methods

	public void setName(String name) {
		this.name = name;
	}
	
	public void setChemicalFormula(String chemicalFormula) {
		this.chemicalFormula = chemicalFormula;
	}
	
	public void setMolarMass(float molarMass) {
		this.molarMass = molarMass;
	}
	
	public void setDensity(float density) {
		this.density = density;
	}

5. Create Print method
	// Print method
	public void print() {
		System.out.printf("Nucleic Acid Properties\n");
		System.out.printf("%s\n", getName());
		System.out.printf("\t%s %s\n", "Chemical formula", getChemicalFormula());
		System.out.printf("\t%s %.5f %s\n", "Molar mass", getMolarMass(), "g/mol");
		System.out.printf("\t%s %.3f %s\n","Density", getDensity(), "g/cm3");
	}