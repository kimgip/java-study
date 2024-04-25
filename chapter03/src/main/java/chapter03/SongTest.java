package chapter03;

public class SongTest {

	public static void main(String[] args) {
		Song song = new Song("좋은날", "아이유", "real", "이민수", 3, 2010);
//		song.setTitle("좋은날");
//		song.setArtist("아이유");
//		song.setAlbum("real");
//		song.setComposer("이민수");
//		song.setTrack(3);
//		song.setYear(2010);
		
		song.show();
	}

}
