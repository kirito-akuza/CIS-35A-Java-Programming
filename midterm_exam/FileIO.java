package midterm_exam;

import java.util.*;

public class FileIO {
	
	private MusicCollection m;
	Scanner in = new Scanner(System.in);
	
	public FileIO() {
		m = new MusicCollection();
	}
	
	public MusicCollection readData() {
		
		System.out.print("How many artists are there? ");
		int n = in.nextInt();
		in.nextLine();
		
		m.setNumberofArtist(n);
		
		for (int i = 0 ; i < n; i++) {
			Artist artist = new Artist();
			System.out.print("Artist " + (i+1) +"'s name: ");
			artist.setName(in.nextLine());
			System.out.print("Artist " + (i+1) +"'s age: ");
			artist.setAge(in.nextInt());
			in.nextLine();
			
			m.setArtist(i, artist);
		}
		
		System.out.print("How many recordings are there? ");
		int k = in.nextInt();
		in.nextLine();
		m.setNumberofRecording(k);
		
		for (int i = 0 ; i < k; i++) {
			Recording recording = new Recording();
			System.out.print("What is the name of Artist for recording " + (i+1) + ": ");
			String name = in.nextLine();
			
			for(int j = 0; j < m.getNumberofArtist(); j++) {
				if (name.equals(m.getArtist(j).getName()))
					recording.setRecArtist(m.getArtist(j));
			}
			
			System.out.print("How many Tracks are there in the recording " + (i+1) + "? ");
			int t = in.nextInt();
			in.nextLine();
			recording.setNumberofTrack(t);
			
			for (int l = 0; l < t; l++) {
				Track tr = new Track();
				System.out.print("Track " + (l+1) + " name: ");
				tr.setSongName(in.nextLine());
				System.out.print("Track " + (l+1) + " length: ");
				tr.setLength(in.nextLine());
				
				recording.setTrack(l, tr);
			}
			
			m.setRecording(i, recording);
		}
		
		return m;
	}
}
