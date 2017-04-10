package neveruseswitch;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Evegeny on 09/04/2017.
 */
public class MailSender {
    private Map<Integer,MailGenerator> map = new HashMap<>();
    private Reflections reflections = new Reflections("neveruseswitch");


    @SneakyThrows
    public MailSender() {
        Set<Class<? extends MailGenerator>> classes = reflections.getSubTypesOf(MailGenerator.class);
        for (Class<? extends MailGenerator> generatorClass : classes) {
            if (!Modifier.isAbstract(generatorClass.getModifiers())) {
                MailCode annotation = generatorClass.getAnnotation(MailCode.class);
                if (annotation == null) {
                    throw new IllegalStateException("class which implement " + MailGenerator.class.getName() + " should be annotataed with MailCode annotation");
                }
                int mailCode = annotation.value();
                if (map.containsKey(mailCode)) {
                    throw new RuntimeException(mailCode + " already in use");
                }
                map.put(mailCode, generatorClass.newInstance());
            }
        }
    }

    public void sendMail() {
        MailInfo mailInfo = DBUtils.getMailInfo();
        int mailCode = mailInfo.getMailCode();
        MailGenerator mailGenerator = map.get(mailCode);
        if (mailGenerator == null) {
            throw new RuntimeException(mailCode + " not supported yet");
        }
        String mail = mailGenerator.generateMail(mailInfo.getClientData());
        send(mail);

    }

    private void send(String mail) {
        System.out.println("mail was sent " + mail);
    }


}
















