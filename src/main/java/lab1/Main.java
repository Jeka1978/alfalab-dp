package lab1;

/**
 * Created by Evegeny on 09/04/2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        MailSender mailSender = new MailSender();
        while (true) {
            mailSender.sendMail();
            Thread.sleep(1000);
        }
    }
}
