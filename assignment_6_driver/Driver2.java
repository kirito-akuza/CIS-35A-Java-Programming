/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 6
 * Due Date: 03/19/2022
 * Date Submitted: 03/19/2022
 */

package assignment_6_driver;

import java.io.IOException;

import assignment_6_exception.StudentGradingException;
import assignment_6_util.FileIO;
import assignment_6_util.Statistics;
import assignment_6_util.Student;
import assignment_6_util.StudentGrade;

public class Driver2 {

	public static void main(String[] args) throws IOException {
		Student[] myStudent = new Student[40];
		boolean problemFixed = false;
		FileIO f = new FileIO("C:\\Users\\Nathan Dinh\\eclipse-workspace\\CIS_35A\\src\\assignment_6_util\\student_data.txt");
	
		do {
			try {
				System.out.println("Accessing file with directory: " + f.getFileName());
				
				// problemFixed = true if file read successfully
				problemFixed = f.ReadFile(f.getFileName(), myStudent);
				System.out.println("File read successfully!");
				myStudent = f.getStudent();
				
				// Call method serializeGrades() to serialize myStudent object
				System.out.println("Serializing file...");
				FileIO.serializeGrades(buildStudGradArray(myStudent));
				System.out.println("Serializing file completed!");

				// Display score to the screen after deserialize
				System.out.println("Deserialize with student ID = " + myStudent[0].getID() + "....");
				System.out.println("Score of student with ID = " + myStudent[0].getID());
				System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "ID", "Quiz 1", "Quiz 2", "Quiz 3", "Quiz 4", "Quiz 5");
				System.out.printf("%-10d", myStudent[0].getID());
				for (int i = 0; i < 5; i++) {
					System.out.printf("%-10d", FileIO.deserializeGrades(myStudent[0].getID()).getStudents().getScore(i));
				}
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
	
	// Static method of buildStudGradArray() return type StudentGrade[]
	public static StudentGrade[] buildStudGradArray(Student[] a) {
		// Create Statistics object and studentGrade array
		Statistics statlab6 = new Statistics();
		StudentGrade[] studentGrade = new StudentGrade[15];
		for (int i = 0; i < Student.getNumberOfStudents(); i++) {
			studentGrade[i] = new StudentGrade(a[i], statlab6, a);
		}
		// return the value
		return studentGrade;
	}
}
