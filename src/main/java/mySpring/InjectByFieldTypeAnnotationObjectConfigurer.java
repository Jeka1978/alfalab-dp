package mySpring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class InjectByFieldTypeAnnotationObjectConfigurer implements ObjectConfigurer {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByFieldType.class)) {
                Object object = ObjectFactory.getInstance().createObject(field.getType());
                field.setAccessible(true);
                field.set(t,object);
            }
        }
    }
}







