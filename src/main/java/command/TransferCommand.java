package command;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Evegeny on 10/04/2017.
 */
@Data
@AllArgsConstructor
public class TransferCommand implements Command {
    private BankAccount bankAccountFrom;
    private BankAccount bankAccountTo;
    private int amount;
    @Override
    public void execute() {
        bankAccountFrom.decreaseBalance(amount);
        bankAccountTo.increaseBalance(amount);
    }
}
