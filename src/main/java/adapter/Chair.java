package adapter;

import lombok.Data;

/**
 * Created by Evegeny on 10/04/2017.
 */
@Data
public class Chair implements Costable {
    @Override
    public int getCost() {
        return 100;
    }
}
