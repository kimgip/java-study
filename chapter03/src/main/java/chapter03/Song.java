package chapter03;

public class Song {
	private int track;
	private int year;
	private String title;
	private String artist;
	private String composer;
	private String album;
	
	public Song(String title, String artist) {
		this(title, artist, "", "", 0, 0);
		
//		System.out.println("some code1");
//		System.out.println("some code2");
//		System.out.println("some code3");
//		System.out.println("some code4");
//		System.out.println("some code5");
	}
	
	public Song(String title, String artist, String composer, String album, int track, int year) {
		this.title = title;
		this.artist = artist;
		this.composer = composer;
		this.album = album;
		this.track = track;
		this.year = year;
		
		System.out.println("some code1");
		System.out.println("some code2");
		System.out.println("some code3");
		System.out.println("some code4");
		System.out.println("some code5");
	}

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
