package adapter;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class Main {
    public static void main(String[] args) {
        LegacyService legacyService = new LegacyService();
        NewService newService = new NewService();
        Costable product = legacyService.getProduct();
        newService.printProductPrice(new Costable2PricebleAdapter(product));
    }
}
