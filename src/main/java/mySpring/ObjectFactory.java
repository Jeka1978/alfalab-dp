package mySpring;

import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Reflections scanner = new Reflections("mySpring");
    private List<ObjectConfigurer> objectConfigurers = new ArrayList<>();
    private List<ProxyConfigurer> proxyConfigurers = new ArrayList<>();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }


    @SneakyThrows
    private ObjectFactory() {
        initObjectConfigurers();
        initProxyConfigurers();
    }

    private void initProxyConfigurers() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends ProxyConfigurer>> classes = scanner.getSubTypesOf(ProxyConfigurer.class);
        for (Class<? extends ProxyConfigurer> aClass : classes) {
            proxyConfigurers.add(aClass.newInstance());
        }
    }

    private void initObjectConfigurers() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends ObjectConfigurer>> configurerClasses = scanner.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> configurerClass : configurerClasses) {
            objectConfigurers.add(configurerClass.newInstance());
        }

    }

    @SuppressWarnings("unchecked")
    @SneakyThrows
    public <T> T createObject(Class<T> type) throws IllegalAccessException, InstantiationException {
        Class<T> realClass = resolveImpl(type);
        T t = realClass.newInstance();
        configure(t);
        inokeInitMethods(realClass, t);
        t = wrapWithProxy(realClass, t);
        return t;
    }










    private <T> T wrapWithProxy(Class<T> realClass, T t) {
        for (ProxyConfigurer proxyConfigurer : proxyConfigurers) {
            t = proxyConfigurer.wrapWithProxy(t, realClass);
        }
        return t;
    }

    private <T> void inokeInitMethods(Class<T> realClass, T t) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = realClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }


    private <T> void configure(T t) {
        objectConfigurers.forEach(configurer -> configurer.configure(t));
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












