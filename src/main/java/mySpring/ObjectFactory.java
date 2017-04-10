package mySpring;

import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Reflections scanner = new Reflections("mySpring");
    private DataFactory dataFactory = new DataFactory();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }


    private ObjectFactory() {
    }

    @SuppressWarnings("unchecked")
    public <T> T createObject(Class<T> type) throws IllegalAccessException, InstantiationException {
        Class<T> realClass = resolveImpl(type);
        T t = realClass.newInstance();


        Set<Field> fields = ReflectionUtils.getAllFields(realClass,field -> field.isAnnotationPresent(InjectRandomInt.class));
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            int min = annotation.min();
            int max = annotation.max();
            int value = dataFactory.getNumberBetween(min, max);
            field.setAccessible(true);
            field.set(t,value);
        }


        return t;
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












