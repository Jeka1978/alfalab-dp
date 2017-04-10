package command;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class AccountManager {
    private Deque<Command> commands = new LinkedList<>();

    public void withdrawMoney(BankAccount account, int amount) {
        new WithdrawCommand(account, amount).execute();
        commands.add(new DepositCommand(account, amount));
    }

    public void undo() {
        if (!commands.isEmpty()) {
            commands.removeLast().execute();
        }
    }
}
