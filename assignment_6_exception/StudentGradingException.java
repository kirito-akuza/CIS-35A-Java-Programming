/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 6
 * Due Date: 03/19/2022
 * Date Submitted: 03/19/2022
 */

package assignment_6_exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import assignment_6_util.FileIO;
import assignment_6_util.Student;

public class StudentGradingException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	// Getting data from keyboard
	Scanner in = new Scanner(System.in);
	
	// Declares variables
	private static int version = 0;
	private int errorno;
	private String errormsg;

	// Constructors
	public StudentGradingException() {
		super();
	}
	
	public StudentGradingException(String errormsg) {
		super();
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public StudentGradingException(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}
	
	public StudentGradingException(int errorno, String errormsg) {
		super();
		this.errormsg = errormsg;
		this.errorno = errorno;
		printmyproblem();
	}
	
	// Mutators - Setters
	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}
	
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	// Accessors - Getters
	public int getErrorno() {
		return errorno;
	}
	
	public String getErrormsg() {
		return errormsg;
	}
	
	// Method of print problem and write the problem to log file
	public void printmyproblem() {
		System.out.println("\nFixProblems [errorno = " + errorno + ", errormsg = " + errormsg + "]");
		writeToFile("FixProblems [errorno = " + errorno + ", errormsg = " + errormsg + "]\n");
	}
	
	// Method of fixing problems of file not found
	public String fixProblemReadFromConsole(int errorno) {
		String path = null;
		if (errorno == 101) {
			System.out.println("Getting file directory...");
			path = "C:\\Users\\Nathan Dinh\\eclipse-workspace\\CIS_35A\\src\\assignment_6_util\\student_data.txt";
			
			writeToFile("Fixing Problem [errorno = " + errorno + ", errormsg = " + errormsg + "]\n");
			writeToFile("Getting file's path...\n");
			writeToFile("File Path: ");
			writeToFile(path + "\n");
			writeToFile("\n");
		}
		return path;
	}
	
	// Method of fixing problems of wrong number format
	public String fixProblemReadFromConsole(FileIO f, int countLine, int count, Student[] myStudent, int errorno) throws IOException {
		String path = null;
		// Check error code to determine what problem
		if (errorno == 404) {
			// If count == 1 -> The first student has wrong number format in maybe student ID or score 
			if(count == 1) {
				// Print to the screen and write to log file
				System.out.println("Score format error for the student with id = 1234");
				writeToFile("Fixing Problem [errorno = " + errorno + ", errormsg = " + errormsg + "]\n");
				writeToFile("Score format error for the student with id = 1234\n");
			} else {
				// Print to the screen and write to log file
				writeToFile("Score format error after student with id: " + myStudent[count-2].getID());
				writeToFile("\n");
				System.out.println("Score format error after student with id: " + myStudent[count-2].getID());
			}
			// Increase version by one after create new back up file after fixing one problem
			version++;
			String back_up_file_name = "C:\\Users\\Nathan Dinh\\eclipse-workspace\\CIS_35A\\src\\assignment_6_util\\Back_up_student_file" + "_" + version + ".txt";
			// Overwrite the file - clear the file
			FileWriter a1 = new FileWriter(back_up_file_name, false);
			a1.close();
			
			// Append again student data with correction
			FileWriter a2 = new FileWriter(back_up_file_name, true);
			
			// Reading the data of student
			FileReader file = new FileReader(f.getFileName());
			
			// BufferReader will read fileReader line by line
			BufferedReader buff = new BufferedReader(file);
		
			// Declare variables
			boolean eof = false;
			int i = 0;
			
			while(!eof) {
				// Reading a line
				String line = buff.readLine();
				
				if(line == null)
					eof = true;
				else if (i == countLine) {
					// Append data of student that has wrong number format
					System.out.println("Please enter by hand data of the next student");
					System.out.print("Student id: ");
					a2.write(in.nextInt() + " ");
					System.out.print("Score 1: ");
					a2.write(in.nextInt() + "  ");
					System.out.print("Score 2: ");
					a2.write(in.nextInt() + "  ");
					System.out.print("Score 3: ");
					a2.write(in.nextInt() + "  ");
					System.out.print("Score 4: ");
					a2.write(in.nextInt() + "  ");
					System.out.print("Score 5: ");
					a2.write(in.nextInt() + "  " + "\n");
					a2.write("\n");
					
					// Skip that student while reading
					buff.readLine();
				} else {
					// Append data of student
					a2.write(line + "\n");
				}
				i++;
			}
			// Close file reader - file writter - buffered reader
			a2.close();
			file.close();
			buff.close();
			
			// Setting path to the new file with correction
			path = back_up_file_name;
		}
		
		// Write to log file
		writeToFile("Creating new back up file with correction...\n");
		writeToFile("New file with correction is ready to use...\n");
		writeToFile("New file path: ");
		writeToFile(path + "\n");
		writeToFile("\n");
		// Return the new path
		return path;
	}
	
	// Method of writting log file
	public void writeToFile(String message) {
		try {
			FileWriter a1 = new FileWriter("C:\\Users\\Nathan Dinh\\eclipse-workspace\\CIS_35A\\src\\assignment_6_util\\Logging.txt", true);
			a1.write(message);
			a1.close();
		} catch (IOException e) {
			System.out.println("Problem creating Logging.txt");
		}
	}
}
