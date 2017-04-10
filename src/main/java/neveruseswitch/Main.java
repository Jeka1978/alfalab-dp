package neveruseswitch;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Evegeny on 09/04/2017.
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws InterruptedException {

        try {
            MailSender mailSender = new MailSender();
            while (true) {
                mailSender.sendMail();
                Thread.sleep(1000);
            }
        } catch (Throwable e) {
            throw e;
        }
    }
}
