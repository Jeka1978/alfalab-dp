package command;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Evegeny on 10/04/2017.
 */
@Data
@AllArgsConstructor
public class WithdrawCommand implements Command {
    private BankAccount bankAccount;
    private int amount;
    @Override
    public void execute() {
        bankAccount.decreaseBalance(amount);
    }
}
