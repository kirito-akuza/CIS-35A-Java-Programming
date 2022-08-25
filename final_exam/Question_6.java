package final_exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Question_6 {
	private String filename;
	
	public Question_6() {
		filename = "";
	}
	
	public Question_6(String filename) {
		this.filename = filename;
	}
	
	public void setFileName(String filename) {
		this.filename = filename;
	}
	
	public String getFileName() {
		return filename;
	}
	
	class WordCounter {
		public int getWordCount() throws FileNotFoundException {
			int count = 0;
			try {
				FileReader file = new FileReader(getFileName());
				BufferedReader buff = new BufferedReader(file);
				boolean eof = false;
				while(!eof) {
					String line = buff.readLine();
					if (line == null) {
						eof = true;
					}
					else {
						StringTokenizer st = new StringTokenizer(line);
						while(st.hasMoreTokens()) {
							st.nextToken();
							count++;
						}
					}
				}
				file.close();
				buff.close();
			}
			catch(FileNotFoundException e) {
				throw new FileNotFoundException();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return count;
		}
	}

	public static void main(String[] agrs) {
		Question_6 q6 = new Question_6("text.txt");
		Question_6.WordCounter counter = q6.new WordCounter();
		try {
			System.out.println("Number of words in file: " + counter.getWordCount());
		}
		catch (FileNotFoundException e) {
			System.out.println("The system cannot find the file specified");
		}
	}

}
