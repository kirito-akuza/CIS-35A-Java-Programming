package final_exam;

import java.util.Scanner;

public class Question_5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Password: ");
		String password = in.nextLine();
		
		String encryptedPass = Encrypted(password);
		System.out.println("Here is the encrypted password: " + encryptedPass);
		in.close();
	}
	
	static String Encrypted(String pass) {
		String newPass = "";
		for(int i = 0; i < pass.length(); i++) {
			if ((pass.charAt(i) >= 'a' && pass.charAt(i) <= 'z') || (pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z')) {
				newPass += Integer.toString((int)pass.charAt(i));
			}
			else if (pass.charAt(i) >= '0' && pass.charAt(i) <= '9') {
				switch (pass.charAt(i)) {
					case '0': 
						newPass += "a";
						break;
					case '1':
						newPass += "b";
						break;
					case '2':
						newPass += "c";
						break;
					case '3':
						newPass += "d";
						break;
					case '4':
						newPass += "e";
						break;
					case '5':
						newPass += "f";
						break;
					case '6':
						newPass += "g";
						break;
					case '7':
						newPass += "h";
						break;
					case '8':
						newPass += "i";
						break;
					case '9':
						newPass += "j";
						break;
				}
			}
			else {
				newPass += "0";
			}
		}
		return newPass;
	}
}
