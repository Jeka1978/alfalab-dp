package callback.method;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java", "java", "GROOVY", "grooVy");
        ListUtil.countDupplicates(strings, "groovy", String::equalsIgnoreCase);
    }
}




