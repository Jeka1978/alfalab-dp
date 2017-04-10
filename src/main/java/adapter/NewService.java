package adapter;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class NewService {
    public void printProductPrice(Pricable pricable) {
        System.out.println("price = " + pricable.getPrice());
    }
}
