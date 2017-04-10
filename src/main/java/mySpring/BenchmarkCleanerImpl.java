package mySpring;

import lombok.experimental.Delegate;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class BenchmarkCleanerImpl implements Cleaner{

    @InjectByFieldType
    @Delegate(excludes = CleanExclude.class)
    private CleanerImpl cleaner;

    @Override
    public void clean(){
        long start = System.nanoTime();
        cleaner.clean();
        long end = System.nanoTime();
        System.out.println(end-start);
    }
}
