package gradle;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evegeny on 10/04/2017.
 */
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractTask implements Task {
    private List<Task> dependsOn = new ArrayList<>();

    public void addTask(Task task) {
        dependsOn.add(task);
    }
    public void removeTask(Task task) {
        dependsOn.remove(task);
    }

    @Override
    public void execute() {
        dependsOn.forEach(Task::execute);
        myExecute();
    }

    public abstract void myExecute();

}


