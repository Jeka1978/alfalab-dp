package adapter;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class LegacyService {
    public Costable getProduct(){
        return new Chair();
    }
}
