package final_exam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Question_3 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String CPUSpeed;
	private String RAM;
	
	public Question_3(String CPUSpeed, String RAM) {
		this.CPUSpeed = CPUSpeed;
		this.RAM = RAM;
	}
	
	public void setCPUSpeed(String CPUSpeed) {
		this.CPUSpeed = CPUSpeed;
	}
	
	public void setRAM(String RAM) {
		this.RAM = RAM;
	}
	
	public String getCPUSpeed() {
		return CPUSpeed;
	}
	
	public String getRAM() {
		return RAM;
	}
	
	public static void main(String[] args) {
		String file = "Question3.txt";
		try {
			ObjectInputStream iob = new ObjectInputStream(new FileInputStream(file));
			try {
				Question_3 q3 = (Question_3)iob.readObject();
				System.out.println("CPU Speed: " + q3.getCPUSpeed());
				System.out.println("RAM: " + q3.RAM);
			}
			catch (ClassNotFoundException e) {
				ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(file));				
				Scanner in = new Scanner(System.in);
				System.out.println("Class Not Found");
				System.out.print("CPUSpeed: ");
				String speed = in.nextLine();
				System.out.print("RAM: ");
				String ram = in.nextLine();
				Question_3 q3 = new Question_3(speed, ram);
				oss.writeObject(q3);
				in.close();
				oss.close();
			}
			iob.close();
		}
		catch(IOException e) {
			System.out.println("Error I/O");
		}
	}
}
