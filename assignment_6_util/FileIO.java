/* Name: Trung Nghia Dinh
 * Class and Section: CIS 35A - 63Z
 * Assignment Number: Assignment 6
 * Due Date: 03/19/2022
 * Date Submitted: 03/19/2022
 */

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
						setStudent(stu);
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
