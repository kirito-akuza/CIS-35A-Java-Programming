/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 6
 * Due Date: 03/19/2022
 * Date Submitted: 03/19/2022
 */

package assignment_6_adapter;

import java.io.IOException;

import assignment_6_exception.StudentGradingException;
import assignment_6_util.*;

public abstract class StudentAPIImpl implements StudentAPI {
	
	// Constructor
	public StudentAPIImpl() throws IOException {
		// Create array of myStudent
		Student[] myStudent = new Student[40];
		
		// Create a flag to continue fixing if meet any problem while reading data
		boolean problemFixed = false;
		
		// Set file location
		FileIO f = new FileIO("C:\\Users\\Nathan Dinh\\eclipse-workspace\\CIS_35A\\src\\assignment_6_util\\student_data.txt");
		do {
			try {
				System.out.println("Accessing file with directory: " + f.getFileName());
				
				// problemFixed = true if file read successfully
				problemFixed = f.ReadFile(f.getFileName(), myStudent);
				System.out.println("File read successfully!");

				// Update myStudent after reading the file
				myStudent = f.getStudent();
				
				// Create Statistics object
				Statistics statlab6 = new Statistics();
				
				// Create array of studentGrade
				StudentGrade[] studentGrade = new StudentGrade[15];
				
				// Run a loop to set-up studentGrade object
				for (int i = 0; i < Student.getNumberOfStudents(); i++) {
					studentGrade[i] = new StudentGrade(myStudent[i], statlab6, myStudent);
				}
				
				// Call method serializeGrades with studentGrade argument to serialize
				System.out.println("Serializing file...");
				FileIO.serializeGrades(studentGrade);
				System.out.println("Serializing file completed!");

			} catch(StudentGradingException e) {
				// If file location is wrong -> fix that problem
				if (e.getErrormsg().equals("File Not Found")) {
					f.setFileName(e.fixProblemReadFromConsole(101));
					// If a score or student id is not a number -> fix that problem
				} else if (e.getErrormsg().equals("Invalid Number Format")) {
					String path = e.fixProblemReadFromConsole(f, FileIO.getCountLine(), FileIO.getCount(), f.getStudent(), 404);
					f.setFileName(path);
				}
			}
			// If problems are not fixed -> keep fixing it
		} while (problemFixed == false);
	}
	
	// Method to print statistics data
	public void printStatistics() {
		// Create StudentGrade object
		StudentGrade studentGrade;
		try {
			// Deserialize a student file with student id argument
			// After deserialize, return studentGrade object
			studentGrade = FileIO.deserializeGrades(1234);
			
			// Call printStatistics() method to print statistics' data
			studentGrade.printStatistics();
		} catch(StudentGradingException e) {
			// Print to the screen fail message
			System.out.println("Deserialize Failed in API");
			// Write to Logging.txt file
			e.writeToFile("Deserialize Failed in API\n");
		}
	}
	
	// Method of print a student score by student ID
	public void printStudentScore(int sid) {
		// Create StudentGrade object
		StudentGrade studentGrade;
		try {
			// Deserialize and return the StudentGrade value
			studentGrade = FileIO.deserializeGrades(sid);
			System.out.println("Deserialize with student ID = " + sid);
			// Display score to the screen
			System.out.println("\nScore of student with ID = " + sid);
			System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "ID", "Quiz 1", "Quiz 2", "Quiz 3", "Quiz 4", "Quiz 5");
			System.out.printf("%-10d", sid);
			for (int i = 0; i < 5; i++) {
				System.out.printf("%-10d", studentGrade.getStudents().getScore(i));	
			}
			System.out.println();
			System.out.println();
		} catch(StudentGradingException e) {
			// Print to the screen fail message
			System.out.println("Deserialize Failed in API");
			// Write to Logging.txt file
			e.writeToFile("Deserialize Failed in API\n");
		}
	}
}
