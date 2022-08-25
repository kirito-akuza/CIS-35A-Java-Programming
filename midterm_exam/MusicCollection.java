package midterm_exam;

public class MusicCollection {
	
	Artist[] artists;
	Recording[] recordings;
	
	public void setNumberofArtist(int i) {
		artists = new Artist[i];
	}
	
	public void setNumberofRecording(int i) {
		recordings = new Recording[i];
	}
	
	public void setArtist(int i, Artist artists) {
		this.artists[i] = artists;
	}
	
	public void setRecording(int i, Recording recordings) {
		this.recordings[i] = recordings;
	}
	
	public int getNumberofArtist() {
		return artists.length;
	}
	
	public int getNumberofRecordings() {
		return recordings.length;
	}
	
	public Artist getArtist(int i) {
		return artists[i];
	}
	
	public Recording getRecording(int i) {
		return recordings[i];
	}
}
