package mySpring;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by Evegeny on 10/04/2017.
 */
public class BenchmarAnnotationProxyConfigurer implements ProxyConfigurer {

    @Override
    @SuppressWarnings("unchecked")
    public <T> T wrapWithProxy(T t, Class<T> type) {
        boolean classNeedBenchmark = type.isAnnotationPresent(Benchmark.class);
        boolean methodNeedsBenchmark = Arrays.stream(type.getMethods()).anyMatch(method -> method.isAnnotationPresent(Benchmark.class));
        if (classNeedBenchmark||methodNeedsBenchmark) {
            if (type.getInterfaces().length == 0) {
               return (T) Enhancer.create(type, (net.sf.cglib.proxy.InvocationHandler) (o, method, args) -> inoke(method, args, type, classNeedBenchmark, t));
            }
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), (proxy, method, args) -> inoke(method, args, type, classNeedBenchmark, t));
        }
        return t;
    }

    private <T> Object inoke(Method method, Object[] args, Class<T> type, boolean classNeedBenchmark, T t) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
        if (classNeedBenchmark||classMethod.isAnnotationPresent(Benchmark.class)) {
            System.out.println("********BENCHMARK OF METHOD "+method.getName()+" start ***************");
            long start = System.nanoTime();
            Object retVal = method.invoke(t, args);
            long end = System.nanoTime();
            System.out.println(end-start);
            System.out.println("********BENCHMARK OF METHOD "+method.getName()+" end ***************");
            return retVal;
        }else {
            return method.invoke(t, args);
        }
    }
}
