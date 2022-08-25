/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 2 - Part 2
 * Due Date: 01/31/2022
 * Date Submitted: 01/31/2022
 */

package assignment_2_part_2;

public class NucleicAcid {
	
	private String name, chemicalFormula;
	private float molarMass, density;
	
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
	
	// Accessors - Getters
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
	
	// Mutators - Setters
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
	
	// Print method
	public void print() {
		System.out.printf("\nNucleic Acid Properties\n");
		System.out.printf("%s\n", getName());
		System.out.printf("\t%s %s\n", "Chemical formula", getChemicalFormula());
		System.out.printf("\t%s %.5f %s\n", "Molar mass", getMolarMass(), "g/mol");
		System.out.printf("\t%s %.3f %s\n","Density", getDensity(), "g/cm3 (calculated)");
	}
}
