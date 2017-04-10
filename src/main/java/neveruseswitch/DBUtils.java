package neveruseswitch;

import java.util.Random;

/**
 * Created by Evegeny on 09/04/2017.
 */
public class DBUtils {
    private static Random random = new Random();

    public static MailInfo getMailInfo() {
        return new MailInfo(new ClientData(), random.nextInt(3) + 1);
    }
}
