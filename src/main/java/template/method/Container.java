package template.method;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evegeny on 10/04/2017.
 */
public abstract class Container implements Component{
    private List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    protected abstract int getSelfCost();

    @Override
    public int getCost() {
        int total = getSelfCost();
        for (Component component : components) {
            total += component.getCost();
        }
        return total;
    }
}






