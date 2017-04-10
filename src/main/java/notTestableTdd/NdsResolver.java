package notTestableTdd;

/**
 * Created by Evegeny on 09/04/2017.
 */
public class NdsResolver {
    private static NdsResolver ourInstance = new NdsResolver();

    public static NdsResolver getInstance() {
        return ourInstance;
    }

    private NdsResolver() {
    }

    public double getNDS(){
        throw new UnsupportedOperationException();
    }
}
