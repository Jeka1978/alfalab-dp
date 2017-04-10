package mySpring;

import java.lang.reflect.InvocationHandler;
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
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

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
            });
        }
        return t;
    }
}
