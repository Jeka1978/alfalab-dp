package notTestableTdd;

/**
 * Created by Evegeny on 09/04/2017.
 */
public class TaxCalc {
    public double withMaam(double price){
        return NdsResolver.getInstance().getNDS() * price;
    }
}
