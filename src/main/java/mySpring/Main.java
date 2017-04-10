package mySpring;

import lombok.SneakyThrows;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        ObjectFactory factory = ObjectFactory.getInstance();
        /*IRobot iRobot = factory.createObject(IRobot.class);
        iRobot.cleanRoom();*/
        AlfaService alfaService = factory.createObject(AlfaService.class);
        alfaService.doWork();
        alfaService.drinkBeer();
    }
}
