/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 5
 * Due Date: 03/07/2022
 * Date Submitted: 03/07/2022
 */

Instruction to review and run code:

*****************************************Student.java*****************************************************
package assignment_5;

public class Student {
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
	
	public void print() {
		System.out.printf("Student ID: %d\n", this.getID());
		for (int i = 0; i < score.length; i++) {
			System.out.printf("Score Quiz %d: %d\n", i+1, this.getScore(i));
		}
	}
}


*****************************************Statistics.java*****************************************************

package assignment_5;

public class Statistics {
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
	public int getLowScores(int i) {
		return lowscores[i];
	}
	
	public int getHighScores(int i) {
		return highscores[i];
	}
	
	public float getAvgScores(int i) {
		return avgscores[i];
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
}


*****************************************FileIO.java*****************************************************
package assignment_5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileIO {
	
	public static Student[] ReadFile(String fname, Student[] stu) {
		// FileReader needs FileNotFound Exception
		// BufferReader throws IOException
		try {
			// FileReader will read all of the file's content
			FileReader file = new FileReader(fname);
			
			// BufferReader will read fileReader line by line
			BufferedReader buff = new BufferedReader(file);
			
			// Declare variables
			int i = 0;
			boolean eof = false;
			
			while(!eof) {
				// Reading a line
				String line = buff.readLine();
				if(line == null)
					eof = true;
				else {
					// Skip the first line - Skip header row
					if(i == 0) {
						i++;
					}
					
					// Skip the line if it's blank
					else if (line.isBlank());
					
					else {
						// Declare variables
						int k = 0;
						boolean CHECK_ID = true;
						
						// Break string into tokens
						StringTokenizer st = new StringTokenizer(line);
						stu[i-1] = new Student();
						
						// If there is more tokens
						while(st.hasMoreTokens()) {
							// Store first token into Student ID
							if(CHECK_ID) {
								int id = Integer.parseInt(st.nextToken());
								CHECK_ID = false;
								stu[i-1].setID(id); 
							}
							// Store the rest of tokens into each quizzes score
							else {
								stu[i-1].setScore(k, Integer.parseInt(st.nextToken()));
								k++;
							}
						}
						// Count for number of students
						i++;
					}
				}
			}
			// Set number of students
			Student.setNumberOfStudents(i-1);
			
			// Close the buffered reader and the file reader
			buff.close();
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found --" + e.toString());
		} catch (IOException e) {
			System.out.println("Problem reading the file --" + e.toString());
		}
		// return student array
		return stu;
	}
}


*****************************************Driver.java*****************************************************

package assignment_5;

import java.util.*;

public class Driver {
	// Get data from keyboard
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// Declare Variables
		boolean flag = true;
		boolean checkInput = true;
		char key;
		
		// Create array of 40 students
		Student[] myStudent = new Student[40];
		
		// Update myStudent array after reading a file
		myStudent = FileIO.ReadFile("C:\\Users\\Nathan Dinh\\eclipse-workspace\\CIS_35A\\src\\assignment_5\\student_data.txt", myStudent);
		
		// Create instance of Statistical
		Statistics statlab5 = new Statistics();
		statlab5.findlow(myStudent);
		statlab5.findhigh(myStudent);
		statlab5.findavg(myStudent);
		
		// Display User Interface
		System.out.println("Welcome to Statistical Analysis of Scores Application");
		System.out.println("We have data of 5 quizzes from students");
		
		// Check if user want to continue or not
		while (flag) {
			// If key input is invalid -> runUI will not run
			if(checkInput)
				runUI(statlab5);
			
			// Ask user to continue or not
			System.out.print("Do you want to continue? - enter <y/n>: ");
			key = in.next().charAt(0);
			
			// If key is 'y' or 'Y' -> Run UI
			if(key == 'y' || key == 'Y')
				checkInput = true;
			// If key is 'n' or 'N' -> Exit application
			else if (key == 'n' || key =='N')
				flag = false;
			// If key is invalid -> ask user again
			else {
				System.out.println("Invalid Input. Please try it again.");
				checkInput = false;
			}
		}
		// Exiting greeting
		System.out.println("\nThank you! Have a nice day!");	
	}
	
	static void runUI(Statistics statlab5) {
		// Display operation user interface
		System.out.println("Select operation - ");
		System.out.println("1. Enter 1 for printing low scores.");
		System.out.println("2. Enter 2 for printing high scores.");
		System.out.println("3. Enter 3 for printing average scores.");
		System.out.println("4. Enter 4 for printing all statistical data.");
		System.out.print("Enter <1 through 4>: ");
		int i = in.nextInt();
		System.out.println();
		
		// Check if user enters valid number
		while (i < 1 || i > 4) {
			System.out.println("Invalid Input. Please try it again.");
			System.out.println("Select operation - ");
			System.out.println("1. Enter 1 for printing low scores.");
			System.out.println("2. Enter 2 for printing high scores.");
			System.out.println("3. Enter 3 for printing average scores.");
			System.out.println("4. Enter 4 for printing all statistical data.");
			System.out.print("Enter <1 through 4>: ");
			i = in.nextInt();
			System.out.println();
		}
		
		// Displays data
		statlab5.print(i);
	}
}

