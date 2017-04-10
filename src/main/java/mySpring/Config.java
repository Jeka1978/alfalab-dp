package mySpring;

import java.util.Optional;

/**
 * Created by Evegeny on 10/04/2017.
 */
public interface Config {
    <T> Optional<Class<T>> getImpl(Class<T> clazz);
}
