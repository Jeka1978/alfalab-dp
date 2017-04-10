package mySpring;

/**
 * Created by Evegeny on 10/04/2017.
 */
@Benchmark
public class ConsoleSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        System.out.println(message);
    }
}
