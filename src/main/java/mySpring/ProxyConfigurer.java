package mySpring;

/**
 * Created by Evegeny on 10/04/2017.
 */
public interface ProxyConfigurer {
    <T> T wrapWithProxy(T t, Class<T> type);
}
