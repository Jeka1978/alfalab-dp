package gradle;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class Build extends AbstractTask {
    @Override
    public void myExecute() {
        System.out.println("building...");
    }
}
