/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 6
 * Due Date: 03/19/2022
 * Date Submitted: 03/19/2022
 */

package assignment_6_driver;

import java.io.IOException;
import assignment_6_exception.StudentGradingException;
import assignment_6_util.*;

public class Driver1 {

	public static void main(String[] args) throws IOException {
		// Create array of myStudent 
		Student[] myStudent = new Student[40];
		
		// Create a flag to check if the problem is fixed
		boolean problemFixed = false;
		
		// For example get the wrong directory
		FileIO f = new FileIO("C:\\student_data.txt");
	
		do {
			try {
				System.out.println("Accessing file with directory: " + f.getFileName());

				// return true if file is read successfully
				problemFixed = f.ReadFile(f.getFileName(), myStudent);
				System.out.println("File read successfully!");
				
			} catch(StudentGradingException e) {
				
				// If file not found -> Fix that problem
				if (e.getErrormsg().equals("File Not Found")) {
					f.setFileName(e.fixProblemReadFromConsole(101));
					
					// If student ID or score is not a number -> Fix that problem
				} else if (e.getErrormsg().equals("Invalid Number Format")) {
					String path = e.fixProblemReadFromConsole(f, FileIO.getCountLine(), FileIO.getCount(), f.getStudent(), 404);
					f.setFileName(path);
				}
			}
			// If file is read successfully -> Stop the loop
		} while (problemFixed == false);
	}
}
