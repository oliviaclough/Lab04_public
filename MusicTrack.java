//Music Track

public abstract class MusicTrack implements MusicTrackInterface {

    private String title;
    private String length;
    private String artistName;
    private String albumName;
    private int year;

    
    public MusicTrack(String title, String length, String artistName,
		      String albumName, String year) {
	//set common fields
	this.title = title;
	this.length = length;
	this.artistName = artistName;
	this.albumName = albumName;
	this.year = Integer.parseInt(year);
    }

    public String getTitle() {return title;}
    public String getLength() {return length;}
    public String getArtist() {return artistName;}
    public String getAlbum() {return albumName;}
    public int getYear() {return year;}

    public abstract String getFormat();
    public abstract String getAdditionalInfo();
}
