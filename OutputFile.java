//output file

import java.io.*;
import java.util.Locale;

public class OutputFile implements OutputFileInterface{
    private PrintWriter out;
    
    //implement output file interface
    public void open(String outputFileName){
	String t = "TITLE";
	String art = "ARTIST";
	String alb = "ALBUM";
	String len = "LENGTH";
	String yr = "YEAR";
	String addit = "ADDITIONAL_INFORMATION";
	
	try {
	    out = new PrintWriter(outputFileName);	    	} catch (Exception e) {
	    System.out.println(e.toString());
	}
	
	out.format("%-40s%-40s%-40s%-7s%-5s%-40s\n", "TITLE","ARTIST","ALBUM","LENGTH","YEAR","ADDITIONAL_INFORMATION");
    }

    
    public void writeItem(MusicTrack trackToWrite){
	 String format = trackToWrite.getFormat();
	 String title = trackToWrite.getTitle();
	 String artist = trackToWrite.getArtist();
	 String album = trackToWrite.getAlbum();
	 String length = trackToWrite.getLength();
	 String add = trackToWrite.getAdditionalInfo();
	 int year = trackToWrite.getYear();
	 
	 out.format("%-40s%-40s%-40s%-7s%-5d%-40s\n",title, artist, album, length, year, add);
	
    }

    public void close(){
	out.close();
    }

    
}
