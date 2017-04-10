package mySpring;

/**
 * Created by Evegeny on 10/04/2017.
 */

public class IRobot {
    @InjectByFieldType
    private Speaker speaker;
    @InjectByFieldType
    private Cleaner cleaner;

    public void cleanRoom() {
        speaker.speak("I started");
        cleaner.clean();
        speaker.speak("I finished");
    }
}
