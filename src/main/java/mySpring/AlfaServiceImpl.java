package mySpring;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class AlfaServiceImpl implements AlfaService {
    @Override
    public void doWork() {
        System.out.println("Working...");
    }

    @Override
    @Benchmark
    public void drinkBeer() {
        System.out.println("drinking...");
    }
}
