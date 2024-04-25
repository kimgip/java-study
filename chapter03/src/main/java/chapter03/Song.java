package chapter03;

public class Song {
	private int track;
	private int year;
	private String title;
	private String artist;
	private String composer;
	private String album;
	
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	
	public void show() {
		System.out.println(artist+" "+
				title+" ( "+
				album+", "+
				year+", "+
				track+"번 track, "+
				composer+ " 작곡 )");
	}

}
