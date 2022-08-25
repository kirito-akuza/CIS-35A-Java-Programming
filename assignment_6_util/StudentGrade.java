/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 6
 * Due Date: 03/19/2022
 * Date Submitted: 03/19/2022
 */

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
