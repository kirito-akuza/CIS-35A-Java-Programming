package midterm_exam;

public class Driver {

	public static void main(String[] args) {
		
		FileIO file = new FileIO();
		
		MusicCollection m = file.readData();
		
		System.out.println("*********************************");
		System.out.println("Data Collection Summary");
		System.out.println("Number of artist: " + m.getNumberofArtist());
		System.out.println("Number of recording: " + m.getNumberofRecordings());
		
		for(int i = 0; i < m.getNumberofRecordings(); i ++) {
			System.out.printf("Recording %d is belong to %s (age %d) has %d track:\n", (i+1), m.getRecording(i).getRecArtist().getName(), m.getRecording(i).getRecArtist().getAge(), m.getRecording(i).getNumberofTrack());
			for (int j = 0; j < m.getRecording(i).getNumberofTrack(); j++) {
				System.out.printf("_ %s (%s)\n", m.getRecording(i).getTrack(j).getSongName(), m.getRecording(i).getTrack(j).getLength());
			}
		}
	}

}
