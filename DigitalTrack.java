//Digital track

public class DigitalTrack extends MusicTrack {
    private String bitRate;
    private String format;

    public DigitalTrack(String title, String length, String artistName,
			String albumName, String year, String format,
			String bitRate){
	super(title, length, artistName, albumName, year);
	this.bitRate = bitRate;
	this.format = format;
    }

    public String getFormat() { return format; }
    
    public String getAdditionalInfo() {
	return ("Digital BitRate: " + bitRate);
    }
}
