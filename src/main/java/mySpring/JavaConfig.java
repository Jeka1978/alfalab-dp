package mySpring;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class JavaConfig implements Config {

    private Map<Class, Class> ifc2Class = new HashMap<>();

    public JavaConfig() {
        ifc2Class.put(Speaker.class, ConsoleSpeaker.class);
        ifc2Class.put(Cleaner.class, CleanerImpl.class);
    }

    @Override
    @SuppressWarnings("uncheked")
    public <T> Optional<Class<T>> getImpl(Class<T> clazz) {
        return Optional.ofNullable(ifc2Class.get(clazz));
    }
}
