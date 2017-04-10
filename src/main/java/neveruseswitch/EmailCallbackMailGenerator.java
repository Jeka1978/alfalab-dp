package neveruseswitch;

/**
 * Created by Evegeny on 09/04/2017.
 */
@MailCode(2)
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateMail(ClientData clientData) {
        return "don't call us we call you";
    }
}
