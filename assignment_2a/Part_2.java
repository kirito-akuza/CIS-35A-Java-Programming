/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 2a - Part 2
 * Due Date: 01/27/2022
 * Date Submitted: 01/27/2022
 */

package assignment_2a;

public class Part_2 {
	
	public static boolean passed (char[] correct, char[] student) {
		// Calling function totalCorrect() to get the return of the number of correct answers
		// Students will pass if they have the correct answers more than 12
		if (totalCorrect(correct, student) >= 12)
			return true;
		else
			return false;
	}
	
	public static int totalCorrect (char[] correct, char[] student) {
		// Declares a variable to hold the number of correct answers
		int count = 0;
		
		// Variable count will increase 1 if a correct answer same as a student answer
		for (int i = 0; i < correct.length; i++) {
			if (correct[i] == student[i])
				count ++;
		}
		return count;
	}
	
	public static int totalIncorrect (char[] correct, char[] student) {
		// Calling function totalCorrect() to get the number of correctly answered and then return the number of incorrectly answered
		return 15 - totalCorrect(correct, student);
	}
	
	public static int[] questionNumbersMissed (char[] correct, char[] student) {
		// Declares an array containing the questions numbers of the questions that the student missed.
		int[] missedAns = new int[15];
		int index = 0;
		for (int i = 0; i < correct.length; i++) {
			if (correct[i] != student[i]) {
				missedAns[index] = i + 1;
				index++;
			}
		}
		return missedAns;
	}
	
	public static void main(String[] args) {
		// Declares correct answers and student's answers
		char[] correctAns = {'B', 'D', 'A', 'A', 'C', 'D', 'A', 'B', 'C', 'A', 'B', 'C', 'D', 'A', 'B'};
		char[] studentAns = {'A', 'A', 'B', 'B', 'A', 'A', 'D', 'D', 'B', 'B', 'D', 'D', 'C', 'C', 'C'};
		
		// Declares an array get the return of questions numbers of the questions that the student missed
		int[] missed = new int[totalIncorrect(correctAns, studentAns)];
		missed = questionNumbersMissed(correctAns, studentAns);
		
		// Calling passed() function to check for student status. Return true/false and display number of correct and incorrect answers
		if (passed(correctAns, studentAns))
			System.out.println("Passed! Correct: " + totalCorrect(correctAns, studentAns) + ". Incorrect: " + totalIncorrect(correctAns, studentAns));
		else if (!passed(correctAns, studentAns))
			System.out.println("Failed! Correct: " + totalCorrect(correctAns, studentAns) + ". Incorrect: " + totalIncorrect(correctAns, studentAns));
		
		// Displays the questions numbers of the questions that the student missed
		System.out.print("Student missed the question: ");
		for (int i = 0; i < totalIncorrect(correctAns, studentAns); i++) {
			System.out.print(missed[i] + " ");
		}
	}

}
