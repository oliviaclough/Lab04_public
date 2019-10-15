//title bucket
import java.util.ArrayList;

public class TitleBucket implements BucketInterface{
    //implements bucketinterface methods
    private ArrayList<ArrayList<MusicTrack>> titles;

    public TitleBucket(){
	this.titles = new ArrayList<ArrayList<MusicTrack>>(26);
	for (int i=0; i<26; i++){
	    titles.add(new ArrayList<MusicTrack>());
	}
    }

    public void addItem(MusicTrack itemToAdd){
       int comp = Character.toUpperCase(itemToAdd.getTitle().charAt(0)) - 'A';

	for (int outer=0; outer<titles.size(); outer++){
	    if (comp == outer){
		if (titles.get(outer).size() == 0) {
		    titles.get(outer).add(itemToAdd);
		    break;
		}
		for (int inner=0; inner<titles.get(outer).size(); inner++){
		    String addingThis = itemToAdd.getTitle().toLowerCase();
		    String alreadyThere = titles.get(outer).get(inner).getTitle().toLowerCase();
		    int val = addingThis.compareTo(alreadyThere);
		    if(val > 0){
			//adding in bigger
			if(inner == titles.get(outer).size() - 1){
			    titles.get(outer).add(itemToAdd);
			    break;
			}
			else
			    continue;
		    }
		    else if (val < 0){
			//adding in smaller
			titles.get(outer).add(inner, itemToAdd);
			break;
		    }
		    else if (val == 0){
		    	//same title
		    	String artistThere = titles.get(outer).get(inner).getArtist().toLowerCase();
		    	String addingArtist = itemToAdd.getArtist().toLowerCase();
		    	int value = addingArtist.compareTo(artistThere);
			
			if (value == 0){
			    
			    if (titles.get(outer).get(inner).equals(itemToAdd)){
				break;
			    }
			    else{
				titles.get(outer).add(inner,itemToAdd);
				break;
			    }
			}
		    	else if (value > 0){
		    	    titles.get(outer).add(inner+1, itemToAdd);
			    break;
		    	}
		    	else if (value < 0){
		    	    titles.get(outer).add(inner, itemToAdd);
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
    {return titles;}
}
