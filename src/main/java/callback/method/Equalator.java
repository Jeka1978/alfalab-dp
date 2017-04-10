package callback.method;

/**
 * Created by Evegeny on 10/04/2017.
 */
@FunctionalInterface
public interface Equalator<T> {
    boolean equals(T t1, T t2);


}
