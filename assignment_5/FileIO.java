/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 5
 * Due Date: 03/07/2022
 * Date Submitted: 03/07/2022
 */

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
