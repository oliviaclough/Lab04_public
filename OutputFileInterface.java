//output file interface
import java.util.ArrayList;

public interface OutputFileInterface{
    public abstract void open(String outputFileName);

    public abstract void writeItem(MusicTrack trackToWrite);

    public abstract void close();
}
