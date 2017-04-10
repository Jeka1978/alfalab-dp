package neveruseswitch;

/**
 * Created by Evegeny on 09/04/2017.
 */
@MailCode(1)
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateMail(ClientData clientData) {
        return "Welcome new client";
    }
}
