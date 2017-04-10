package tdd;

import lombok.Setter;

/**
 * Created by Evegeny on 09/04/2017.
 */
public class TaxCalculator {
    @Setter
    private NdsResolver ndsResolver = new NdsResolverImpl();

    public double withNds(double price) {
        double nds = ndsResolver.getNds();
        return price * nds+price;
    }


}
