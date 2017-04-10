package template.method;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class Shelf extends Container {
    @Override
    protected int getSelfCost() {
        return 100;
    }
}
