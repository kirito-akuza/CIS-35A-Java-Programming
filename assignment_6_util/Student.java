/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 6
 * Due Date: 03/19/2022
 * Date Submitted: 03/19/2022
 */

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
