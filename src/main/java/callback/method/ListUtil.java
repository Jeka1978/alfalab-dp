package callback.method;

import java.util.List;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class ListUtil {
    public static <T> int countDupplicates(List<T> list, T t, Equalator<T> equalator) {
        int counter=0;
        for (T t1 : list) {
            if (equalator.equals(t, t1)) {
                counter++;
            }
        }
        return counter;
    }
}



