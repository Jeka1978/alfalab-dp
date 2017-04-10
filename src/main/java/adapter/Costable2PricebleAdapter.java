package adapter;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * Created by Evegeny on 10/04/2017.
 */
@RequiredArgsConstructor
@Value
public class Costable2PricebleAdapter implements Pricable {
    private final Costable costable;
    @Override
    public int getPrice() {
        return costable.getCost();
    }
}
