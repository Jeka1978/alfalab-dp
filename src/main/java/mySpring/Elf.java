package mySpring;

import lombok.Data;

/**
 * Created by Evegeny on 10/04/2017.
 */
@Data
public class Elf {
    @InjectRandomInt(min = 10, max = 23)
    private int power;
    private int magicPower;

    public Elf() {
//        power  4 lines of code to init state
    }
}
