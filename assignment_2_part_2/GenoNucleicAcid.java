/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 2 - Part 2
 * Due Date: 01/31/2022
 * Date Submitted: 01/31/2022
 */

package assignment_2_part_2;

import java.util.*;

public class GenoNucleicAcid {
	
	static Scanner in = new Scanner(System.in);
	
	public NucleicAcid inputData() {
		// Declares variables
		String name, chemicalFormula;
		float molarMass;
		float density;
		
		// Get name, chemical formula, molar mass, and density from keyboard
		System.out.println("Please input a Nucleic Acid properties");
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

}
