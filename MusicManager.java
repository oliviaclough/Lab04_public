//Music Manager

import java.util.ArrayList;
import java.util.Scanner;
import java.net.*;
import java.io.*;

public class MusicManager {
    private Scanner scan;
    private ArtistBucket artistBucket;
    private TitleBucket titleBucket;
    private OutputFile output;

    MusicManager() {
	this.artistBucket = new ArtistBucket();
	this.titleBucket = new TitleBucket();
	this.output = new OutputFile();
	this.scan = new Scanner(System.in);
    }
    
    public void start() {
	System.out.println("Welcome to the Music Library Application!");



	
//USER READING FILES IN------------------------------------------------------------------
	System.out.println("Enter `D` to read the music file from your local disk or `W` to read the music file from the web:");
	String input = scan.next();
	while (!(input.equals("W") || input.equals("D")
		 || input.equals("w") || input.equals("d"))) {
	    System.out.println("Invalid input");
	    System.out.println("Enter `D` to read the music file from your local disk or `W` to read the music file from the web:");
	    input = scan.next();
	}



	
//READING IN FILES------------------------------------------------------------------
	if (input.equals("W") || input.equals("w")) {
	    //read from web
		String line;
		Scanner remoteIn = null;
		try {
		    URL remoteFileLocation =new URL("https://sites.cs.ucsb.edu/~richert/cs56/misc/lab04/MusicList.txt");

		    URLConnection connection = remoteFileLocation.openConnection();
		    remoteIn = new Scanner(connection.getInputStream());

		    while (remoteIn.hasNextLine()) {
			//parse through file line by line
			line = remoteIn.nextLine();
			String[] words = line.split(";");
			if (words[5].equals("D")) {
			    DigitalTrack d = new DigitalTrack(words[0], words[1], words[2], words[3], words[4], words[5], words[6]);
			    artistBucket.addItem(d);
			    titleBucket.addItem(d);
			}
			else if (words[5].equals("V")){
			    VinylTrack v = new VinylTrack(words[0], words[1], words[2], words[3], words[4], words[5], words[6]);
			    artistBucket.addItem(v);
			    titleBucket.addItem(v);
			}
		    }
		} catch (IOException e) {
		    System.out.println(e.toString());
		} finally {
		    if (remoteIn != null) {
			remoteIn.close();
		    }
		}
	    }
	
	else {
	    //read from disk
	   Scanner inFile = null;
	   String line;
	   try {
	       inFile = new Scanner(new File("MusicList.txt"));
	       while (inFile.hasNextLine()) {
			//parse through file line by line
			line = inFile.nextLine();
			String[] words = line.split(";");
			if (words[5].equals("D")) {
			    DigitalTrack d = new DigitalTrack(words[0], words[1], words[2], words[3], words[4], words[5], words[6]);
			    artistBucket.addItem(d);
			    titleBucket.addItem(d);
			}
			else if (words[5].equals("V")){
			    VinylTrack v = new VinylTrack(words[0], words[1], words[2], words[3], words[4], words[5], words[6]);
			    artistBucket.addItem(v);
			    titleBucket.addItem(v);
			}
		    }
	       
	   } catch (FileNotFoundException e) {
	       System.out.println(e);
	   }
	}



	
//USER WRITING TO TEXT FILES------------------------------------------------------------------
	System.out.println("Enter `A` to output tracks by Artists or `T` to output tracks by Title. Enter `Q` to quit:");
	String input2 = scan.next();
	while (!(input2.equals("A") || input2.equals("T") || input2.equals("a") ||
		 input2.equals("t") || input2.equals("Q") || input2.equals("q"))) {
	    System.out.println("Invalid input");
	    System.out.println("Enter `A` to output tracks by Artists or `T` to output tracks by Title. Enter `Q` to quit:");
	    input2 = scan.next();
	}



	
//WRITING TO FILES------------------------------------------------------------------
	while (!(input2.equals("q") || input2.equals("Q"))){
	    if (input2.equals("A") || input2.equals("a")){
		//generate artistOutput.txt
		ArrayList<ArrayList<MusicTrack>> print = artistBucket.getBuckets();
		output.open("artistOutput.txt");
		for (int my=0; my<print.size(); my++){
			for (int you=0; you<print.get(my).size(); you++){
			    output.writeItem(print.get(my).get(you));
			}
		}
		output.close();
	    
	    }
	    else if (input2.equals("T") || input2.equals("t")){
		//generate titleOutput.txt
		ArrayList<ArrayList<MusicTrack>> print = titleBucket.getBuckets();
	        
		output.open("titleOutput.txt");
		
		for (int my=0; my < print.size(); my++){
			for (int you=0; you < print.get(my).size(); you++){
			    output.writeItem(print.get(my).get(you));
			}
		}
	        
		output.close();
        
	    }
	    System.out.println("Enter `A` to output tracks by Artists or `T` to output tracks by Title. Enter `Q` to quit:");
	    input2 = scan.next();
	}
    }

    //getter methods

    //setter methods
}
