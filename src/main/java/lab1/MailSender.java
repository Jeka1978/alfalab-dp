package lab1;

/**
 * Created by Evegeny on 09/04/2017.
 */
public class MailSender {
    public void sendMail() {
        MailInfo mailInfo = DBUtils.getMailInfo();
        if (mailInfo.getMailCode() == 1) {
            //70 lines of code
            System.out.println("sending WELCOME mail ");
        }else {
            //50 lines of code
            System.out.println("don't call us we call you");
        }
    }
}
















