//Vinyl track

public class VinylTrack extends MusicTrack {
    private String RPM;
    private String format;

    public VinylTrack(String title, String length, String artistName,
		      String albumName, String year, String format, String RPM){
	super(title, length, artistName, albumName, year);
	this.RPM = RPM;
	this.format = format;
    }

    public String getFormat() {return format;}
    
    public String getAdditionalInfo() {
	return ("Vinyl RPM: " + RPM);
    }
}
