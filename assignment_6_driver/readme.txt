/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 6
 * Due Date: 03/19/2022
 * Date Submitted: 03/19/2022
 */

Instruction to review and run code:

*****************************************Student.java*****************************************************
package assignment_6_util;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	// Declare variables
	private int SID;
	private int[] score;
	private static int numberofstudents;
	
	// Constructor
	public Student() {
		this.SID = 0;
		this.score = new int[5];
		numberofstudents = 0;
	}
	
	// Mutators - Setters
	public void setID(int SID) {
		this.SID = SID;
	}
	
	public void setScore(int i, int score) {
		this.score[i] = score;
	}
	
	// Static method of number of students
	public static void setNumberOfStudents(int i) {
		numberofstudents = i;
	}
	
	// Accessors - Getters
	public int getID() {
		return this.SID;
	}
	
	public int getScore(int i) {
		return this.score[i];
	}
	
	public static int getNumberOfStudents() {
		return numberofstudents;
	}
	
	// Print method
	public void print() {
		System.out.printf("Student ID: %d\n", this.getID());
		for (int i = 0; i < score.length; i++) {
			System.out.printf("Score Quiz %d: %d\n", i+1, this.getScore(i));
		}
	}
}


*****************************************Statistics.java*****************************************************

package assignment_6_util;

import java.io.Serializable;

public class Statistics implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// Declare Variables
	private int[] lowscores;
	private int[] highscores;
	private float[] avgscores;
	
	// Constructor
	public Statistics() {
		lowscores = new int[5];
		highscores = new int[5];
		avgscores = new float[5];
	}
	
	// Method of finding lowest score each quizzes
	public void findlow(Student[] a) {
		int index = 0;
		for (int i = 0; i < lowscores.length; i++) {
			int min = a[0].getScore(i);
			for (int k = 0; k < Student.getNumberOfStudents(); k++)  {
				if (min > a[k].getScore(i)) {
					min = a[k].getScore(i);
				}
			}
			lowscores[index] = min;
			index++;
		}
	}
	
	// Method of finding highest score each quizzes
	public void findhigh(Student[] a) {
		int index = 0;
		for (int i = 0; i < lowscores.length; i++) {
			int max = a[0].getScore(i);
			for (int k = 0; k < Student.getNumberOfStudents(); k++)  {
				if (max < a[k].getScore(i)) {
					max = a[k].getScore(i);
				}
			}
			highscores[index] = max;
			index++;
		}
	}
	
	// Method of calculating average score each quizzes
	public void findavg(Student[] a) {
		int index = 0;
		for (int i = 0; i < avgscores.length; i++) {
			float sum = 0;
			for (int k = 0; k < Student.getNumberOfStudents(); k++) {
				sum += (float)(a[k].getScore(i))/15;
			}
			avgscores[index] = sum;
			index++;
		}
	}
	
	// Accessors - Getters
	public int[] getLowScores() {
		return lowscores;
	}
	
	public int[] getHighScores() {
		return highscores;
	}
	
	public float[] getAvgScores() {
		return avgscores;
	}
	
	// Print method
	public void print(int option) {
		switch(option) {
		case 1:
			System.out.printf("Low Scores in each Quiz:\n");
			for (int i = 0; i < lowscores.length; i++) {
				System.out.printf("Quiz %d: %d\n", i+1, lowscores[i]);
			}
			break;
			
		case 2:
			System.out.printf("High Scores in each Quiz:\n");
			for (int i = 0; i < highscores.length; i++) {
				System.out.printf("Quiz %d: %d\n", i+1, highscores[i]);
			}
			break;
			
		case 3:
			System.out.printf("Average Scores in each Quiz:\n");
			for (int i = 0; i < avgscores.length; i++) {
				System.out.printf("Quiz %d: %.2f\n", i+1, avgscores[i]);
			}
			break;
		
		case 4:
			System.out.printf("Printing all data...\n");
			System.out.printf("%8s%12s%14s%17s\n", "", "Low Scores", "High Scores", "Average Scores");
			for (int i = 0; i < avgscores.length; i++) {
				System.out.printf("Quiz %d%14d%14d%17.2f\n", i+1, lowscores[i], highscores[i], avgscores[i]);
			}
			break;
		}
	}
	
	// Method of print score accept int value
	public void printScores(int[] scores) {
		for (int i = 0; i < 5; i++) {
			System.out.printf("%-10d", scores[i]);
		}
		System.out.println();
	}
	
	// Method of print score accept float value
	public void printScores(float[] scores) {
		for (int i = 0; i < 5; i++) {
			System.out.printf("%-10.2f", scores[i]);
		}
		System.out.println();
	}
}


*****************************************FileIO.java*****************************************************
package assignment_6_util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

import assignment_6_exception.StudentGradingException;

public class FileIO {
	
	// Declare variables
	private static int count_line;
	private static int count;
	private Student[] myStudent;
	private String fname;
	
	// Constructors
	public FileIO() {
		fname = "";
		count_line = 0;
	}
	
	public FileIO(String fname) {
		this.fname = fname;
		count_line = 0;
	}
	
	// Setters - Mutators
	public void setFileName(String fname) {
		this.fname = fname;
	}
	
	public void setStudent(Student[] myStudent) {
		this.myStudent = myStudent;
	}
	
	public static void setCountLine(int number) {
		FileIO.count_line = number;
	}
	
	// Getters - Accessors
	public Student[] getStudent() {
		return myStudent;
	}
	
	public String getFileName() {
		return fname;
	}
	
	public static int getCountLine() {
		return FileIO.count_line;
	}
	
	public static int getCount() {
		return count;
	}
	
	// method of read file - return true if file read successfully
	public boolean ReadFile(String fname, Student[] stu) throws StudentGradingException {
		boolean flag = false;
		// count the line while reading file
		count_line = 0;
		// count the line that is not blank
		count = 0;
		
		// FileReader needs FileNotFound Exception
		// BufferReader throws IOException
		try {
			// FileReader will read all of the file's content
			FileReader file = new FileReader(fname);
			
			// BufferReader will read fileReader line by line
			BufferedReader buff = new BufferedReader(file);
			
			// Declare variables
			boolean eof = false;
			flag = true;
			while(!eof) {
				// Reading a line
				String line = buff.readLine();
				if(line == null)
					eof = true;
				else {
					// Skip the first line - Skip header row
					if(count == 0) {
						count++;
					}
					
					// Skip the line if it's blank
					else if (line.isBlank());
					
					else {
						// Declare variables
						int k = 0;
						boolean CHECK_ID = true;
						
						// Break string into tokens
						StringTokenizer st = new StringTokenizer(line);
						stu[count-1] = new Student();
						
						// If there is more tokens
						while(st.hasMoreTokens()) {
							// Store first token into Student ID
							if(CHECK_ID) {
								int id = Integer.parseInt(st.nextToken());
								CHECK_ID = false;
								stu[count-1].setID(id);
							}
							// Store the rest of tokens into each quizzes score
							else {
								stu[count-1].setScore(k, Integer.parseInt(st.nextToken()));
								k++;
							}
						}
						// Count for number of students
						count++;
					}
				}
				count_line++;
			}
			// set student array after getting data from file
			setStudent(stu);
			// Set number of students
			Student.setNumberOfStudents(count-1);
			// Close the buffered reader and the file reader
			buff.close();
			file.close();
		} catch (FileNotFoundException e) {
			throw new StudentGradingException(101,"File Not Found");
		} catch (IOException e) {
			System.out.println("Problem reading the file --" + e.toString());
		} catch (NumberFormatException e) {
			throw new StudentGradingException(404, "Invalid Number Format");
		}
		finally {}
		// return true if file read successfully
		return flag;
	}
	
	// Method of Serialize objects
	public static void serializeGrades(StudentGrade[] a) throws StudentGradingException {
		try {
			// Loop and serialize objects of all students
			for (int i = 0; i < Student.getNumberOfStudents(); i++) {
				// Setting file directory
				String filename = "C:\\Users\\Nathan Dinh\\eclipse-workspace\\CIS_35A\\src\\assignment_6_util\\" + "Grade_" + a[i].getStudents().getID() + ".dat";
				// Create FileOutputStream with file directory
				FileOutputStream file = new FileOutputStream(filename);
				// Set ObjectOutputStream object related to the FileOutputStream object declared above
				ObjectOutputStream out = new ObjectOutputStream(file);
				// Serialize an object
				out.writeObject(a[i]);
				// Close ObjectOutputStream and FileOutputStream
				out.close();
				file.close();
			}
		} catch (IOException e) {
			throw new StudentGradingException(202,"Serialized File Fail To Open/Close");
		}	
	}

	// Method of Deserialize an object
	public static StudentGrade deserializeGrades(int studid) throws StudentGradingException {
		StudentGrade student;
		try {
			// Setting file directory
			String filename = "C:\\Users\\Nathan Dinh\\eclipse-workspace\\CIS_35A\\src\\assignment_6_util\\" + "Grade_" + studid + ".dat";
			// Create FileInputStream with file directory
			FileInputStream file = new FileInputStream(filename);
			// Set ObjectInputStream object related to the FileInputStream object declared above
			ObjectInputStream in = new ObjectInputStream(file);
			// Deserialize an object
			student = (StudentGrade)in.readObject();
			// Close ObjectInputStream and FileInputStream
			in.close();
			file.close();
		} catch (FileNotFoundException e) {
			throw new StudentGradingException(302,"Deserialize File Fail");
		} catch (IOException e) {
			throw new StudentGradingException(203,"Deserialized File Fail To Open/Close");
		} catch (ClassNotFoundException e) {
			throw new StudentGradingException(505,"Class Not Found");
		}
		// return StudentGrade value
		return student;
	}
}


*****************************************StudentGrade.java*****************************************************

package assignment_6_util;

import java.io.Serializable;

public class StudentGrade implements Serializable {
	// Declares variables
	private static final long serialVersionUID = 1L;
	private Student students;
	private Statistics statistics;
	private Student[] stu;
	
	// Constructors
	public StudentGrade(Student students, Statistics statistics, Student[] stu) {
		this.students = students;
		this.statistics = statistics;
		this.stu = stu;
	}
	
	// Setters - Mutators
	public void setStudents(Student students) {
		this.students = students;
	}
	
	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
	
	public void setStu(Student[] stu) {
		this.stu = stu;
	}
	
	// Getters - Accessors
	public Student getStudents() {
		return students;
	}
		
	public Student[] getStu() {
		return this.stu;
	}
		
	public int getID() {
		return students.getID();
	}
	
	// Method of print highest score each quiz
	public void printHighest() {
		System.out.println("Highest Score");
		System.out.printf("%-10s%-10s%-10s%-10s%-10s\n", "Quiz 1", "Quiz 2", "Quiz 3", "Quiz 4", "Quiz 5");
		statistics.findhigh(stu);
		statistics.printScores(statistics.getHighScores());
		System.out.println();
	}
	
	// Method of print lowest score each quiz
	public void printLowest() {
		System.out.println("Lowest Score");
		System.out.printf("%-10s%-10s%-10s%-10s%-10s\n", "Quiz 1", "Quiz 2", "Quiz 3", "Quiz 4", "Quiz 5");
		statistics.findlow(stu);
		statistics.printScores(statistics.getLowScores());
		System.out.println();
	}
	
	// Method of print average score each quiz
	public void printAverage() {
		System.out.println("Average Score");
		System.out.printf("%-10s%-10s%-10s%-10s%-10s\n", "Quiz 1", "Quiz 2", "Quiz 3", "Quiz 4", "Quiz 5");
		statistics.findavg(stu);
		statistics.printScores(statistics.getAvgScores());
		System.out.println();
	}
	
	// Method of print all statistics data
	public void printStatistics() {
		printHighest();
		printLowest();
		printAverage();
	}
}

*****************************************StudentGradingException.java*****************************************************

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

*****************************************SAPI.java*****************************************************

package assignment_6_adapter;

import java.io.IOException;

public class SAPI extends StudentAPIImpl {
	// Constructor
	public SAPI() throws IOException {
		super();
	}
	
}

*****************************************StudentAPI.java*****************************************************

package assignment_6_adapter;

public interface StudentAPI {
	// Declares some abstract classes
	public void printStudentScore(int sid);
	public void printStatistics();
}

*****************************************StudentAPIImpl.java*****************************************************

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


*****************************************Driver1.java*****************************************************

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
		FileIO f = new FileIO("C:\\Hello.txt");
	
		do {
			try {
				System.out.println("Accessing file with directory: " + f.getFileName());
				
				// return true if file is read successfully
				problemFixed = f.ReadFile(f.getFileName(), myStudent);
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

*****************************************Driver2.java*****************************************************

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

*****************************************Driver3.java*****************************************************
package assignment_6_driver;

import java.io.IOException;
import assignment_6_adapter.SAPI;
import assignment_6_adapter.StudentAPI;

public class Driver3 {
	
	public static void main(String[] args) throws IOException {
		// Create StudentAPI object
		StudentAPI a1 = new SAPI();
		
		// Print student score with student ID and print Statistics
		a1.printStudentScore(6134);
		a1.printStatistics();
	}
	
}