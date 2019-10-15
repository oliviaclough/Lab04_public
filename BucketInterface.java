//bucket interface
import java.util.ArrayList;

public interface BucketInterface {
    //interface
    public abstract void addItem(MusicTrack itemToAdd);

    public abstract ArrayList<ArrayList<MusicTrack>> getBuckets();
}
