/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 3
 * Due Date: 02/14/2022
 * Date Submitted: 02/14/2022
 */

package assignment_3;

import java.io.*;
import java.util.*;

public class FileIO {
	// Declares variables
	private String fname = null;
	// Set DEBUG status to true to print getting data processing to the screen
	private boolean DEBUG = false;
	
	// Constructor
	public FileIO(String fname) {
		this.fname = fname;
	}
	
	// Method of reading data
	public Franchise readData() {
		// Declares variables
		Franchise a1 = null;
		int counter = 0;
		// Exception handling to open and read the file
		try {
			// Open the file
			FileReader file = new FileReader(fname);
			// Create a buffer
			BufferedReader buff = new BufferedReader(file);
			String temp;
			boolean eof = false;
			// Check if the file is end already or not
			while (!eof) {
				// Get the next line and store in line variable
				String line = buff.readLine();
				// Count increases
				counter++;
				// If there are no line -> set eof true
				if (line == null)
					eof = true;
				else {
					if (DEBUG)
						System.out.println("Reading" + line);
					// Get and store number of store
					if (counter == 1) {
						temp = line;
						a1 = new Franchise(Integer.parseInt(temp));
						if (DEBUG)
							System.out.println("d  " + a1.numberofstores());
					}
					// Ignore if counter equals to 2
					if (counter == 2)
						;
					// Create stores
					if (counter > 2) {
						  	int x = buildStore(a1, (counter-3), line);
							if (DEBUG)
								System.out.println("Reading Store # "+(counter-2)+" Number of weeks read =  " +  x);
							if (DEBUG)
							{	
								System.out.println("Data read:");
								// Get the store data
								a1.getStores(counter-3).printdata();
							}
					}
				}
			}
			// Close the buffer
			buff.close();
		} catch (Exception e) {
			// If there is any error while opening and reading the file, catch the exception
			System.out.println("Error -- " + e.toString());
		}
		// Return the value
		return a1;
	}
	
	// Method of building stores
	public int buildStore(Franchise a1, int counter, String temp) {
		// Declares variables
		Store tstore = new Store();
		String s1  =  "";
		float sale = 0.0f;
		int week = 0;
		int day = 0;
		// Break string into tokens
		StringTokenizer st = new StringTokenizer(temp);
	    while (st.hasMoreTokens()) {
	         for(day=0;day<7;day++)
	         {
		    	 s1 = st.nextToken();
		    	 // Convert string to float
		         sale = Float.parseFloat(s1);
		         // Set store's sales by day and week
	        	 tstore.setsaleforweekdayintersection(week, day, sale);
	         }
	         week++;
	    }
	    // Setting a store
		a1.setStores(tstore, counter);
	    return week; 
	}
}
