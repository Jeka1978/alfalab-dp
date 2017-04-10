package command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Evegeny on 10/04/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    private int id;
    private int amount;

    public void decreaseBalance(int delta) {
        amount -= delta;
    }
    public void increaseBalance(int delta) {
        amount += delta;
    }

}
