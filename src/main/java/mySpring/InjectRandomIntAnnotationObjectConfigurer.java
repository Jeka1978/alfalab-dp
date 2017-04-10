package mySpring;

import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class InjectRandomIntAnnotationObjectConfigurer implements ObjectConfigurer {
    private DataFactory dataFactory = new DataFactory();
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> realClass = t.getClass();
        Set<Field> fields = ReflectionUtils.getAllFields(realClass, field -> field.isAnnotationPresent(InjectRandomInt.class));
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            int min = annotation.min();
            int max = annotation.max();
            int value = dataFactory.getNumberBetween(min, max);
            field.setAccessible(true);
            field.set(t,value);
        }
    }
}
