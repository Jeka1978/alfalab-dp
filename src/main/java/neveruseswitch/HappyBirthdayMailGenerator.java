package neveruseswitch;

/**
 * Created by Evegeny on 09/04/2017.
 */
@MailCode(3)
public class HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String generateMail(ClientData clientData) {
        return "Happy Birthday ЧУВАК";
    }
}
