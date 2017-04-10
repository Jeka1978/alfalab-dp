package myReflections;

import lombok.SneakyThrows;

import java.lang.reflect.Method;

/**
 * Created by Evegeny on 09/04/2017.
 */
public class TestRunner {
    @SneakyThrows
    @Deprecated
    public void runAllTestsMethods(Object o) {
        Class<?> aClass = o.getClass();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("test")) {
                method.setAccessible(true);
                method.invoke(o);
            }
        }
    }
}





