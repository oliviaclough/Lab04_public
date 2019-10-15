//Artist Bucket

import java.util.ArrayList;

public class ArtistBucket implements BucketInterface {
    //implements bucketinterface methods
    private ArrayList<ArrayList<MusicTrack>> artists;

    public ArtistBucket(){
	this.artists = new ArrayList<ArrayList<MusicTrack>>(26);
        for (int i=0; i<26; i++){
	    artists.add(new ArrayList<MusicTrack>());
	}
    }
    
    public void addItem(MusicTrack itemToAdd){
       int comp = Character.toUpperCase(itemToAdd.getArtist().charAt(0)) - 'A';

	for (int outer=0; outer<artists.size(); outer++){
	    if (comp == outer){
		if (artists.get(outer).size() == 0) {
		    artists.get(outer).add(itemToAdd);
		    break;
		}
		for (int inner=0; inner<artists.get(outer).size(); inner++){
		    String addingThis = itemToAdd.getArtist().toLowerCase();
		    String alreadyThere = artists.get(outer).get(inner).getArtist().toLowerCase();
		    int val = addingThis.compareTo(alreadyThere);
		    if(val > 0){
			//adding in bigger
			if(inner == artists.get(outer).size() - 1){
			    artists.get(outer).add(itemToAdd);
			    break;
			}
			else
			    continue;
		    }
		    else if (val < 0){
			//adding in smaller
			artists.get(outer).add(inner, itemToAdd);
			break;
		    }
		    else if (val == 0){
			//same artist
			String titleThere = artists.get(outer).get(inner).getTitle().toLowerCase();
			String addingTitle = itemToAdd.getArtist().toLowerCase();
			int value = addingTitle.compareTo(titleThere);
			if (value == 0) {
			    if (artists.get(outer).get(inner).equals(itemToAdd)){
				break;
			    }
			    else{
				artists.get(outer).add(inner,itemToAdd);
				break;
			    }
			}
			else if (value > 0){
			    artists.get(outer).add(inner+1, itemToAdd);
			    break;
			}
			else if (value < 0){
			    artists.get(outer).add(inner, itemToAdd);
			    break;
			}
		    
			  
		   }
		}
	    }
		else
		    continue;
	
    }
    }
    
    
    public ArrayList<ArrayList<MusicTrack>> getBuckets()
    {return artists;}
}
