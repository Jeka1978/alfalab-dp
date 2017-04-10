package mySpring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.Optional;
import java.util.Set;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Reflections scanner = new Reflections("mySpring");

    public static ObjectFactory getInstance() {
        return ourInstance;
    }


    private ObjectFactory() {
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<T> realClass;
        realClass = resolveImpl(type);
        return realClass.newInstance();
    }










    private <T> Class<T> resolveImpl(Class<T> type) {
        Class<T> realClass;
        if (type.isInterface()) {
            Optional<Class<T>> classOptional = config.getImpl(type);
            realClass = classOptional.orElseGet(() -> scanForImpl(type));
        } else {
            realClass = type;
        }
        return realClass;
    }

    private <T> Class<T> scanForImpl(Class<T> type) {
        Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
        if (classes.size() != 1) {
            throw new RuntimeException(type + " has 0 or more than one impl. Please map the one you want into config");
        }
        Class<? extends T> next = classes.iterator().next();
        return (Class<T>) next;
    }
}












