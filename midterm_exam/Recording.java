package midterm_exam;

public class Recording {
	private Track[] track;
	private boolean hasArtist;
	private Artist artist;
	
	public Recording() {
		hasArtist = false;
		track = null;
		artist = new Artist();
	}
	
	public void setNumberofTrack(int i) {
		track = new Track[i];
	}
	
	public void setTrack(int i, Track track) {
		this.track[i] = track;
	}
	
	public void setRecArtist(Artist artist) {
		this.artist = artist;
		hasArtist = true;
	}
	
	public Artist getRecArtist() {
		return artist;
	}
	
	public boolean getRecArtistStatus() {
		return hasArtist;
	}
	
	public Track getTrack(int i) {
		return track[i];
	}
	
	public int getNumberofTrack() {
		return track.length;
	}
	
	
}

class Track {
	private String songName;
	private String length;
	
	public Track() {
		songName = "";
		length = "";
	}
	
	public Track(String songName, String length) {
		this.songName = songName;
		this.length = length;
	}
	
	public void setSongName(String songName) {
		this.songName = songName;
	}
	
	public void setLength(String length) {
		this.length = length;
	}
	
	public String getSongName() {
		return songName;
	}
	
	public String getLength() {
		return length;
	}
}

