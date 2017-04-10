package tdd;

import lombok.SneakyThrows;

/**
 * Created by Evegeny on 09/04/2017.
 */
public class NdsResolverImpl implements NdsResolver {
    @Override
    @SneakyThrows
    public double getNds() {
        Thread.sleep(3000);
        return 0.16;
    }
}
