//package root.lesson_10;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Proxy;
//
//public class SomeClassLoader {
//
//    void invokeClassRuntime() throws Throwable {
//        final ClassLoader classLoader = SomeClassCompiler.class.getClassLoader();
//        InvocationHandler handler = ((proxy, method, arr) -> method.invoke(proxy,arr));
//        Object doWork = handler.invoke(new SomeClassCompiler(), Worker.class.getMethod("doWork",
//                (Class<?>) null), null);
//
//        Worker newProxyInstance = (Worker) Proxy.newProxyInstance(
//                classLoader,
//                new Class[]{Worker.class},
//                handler
//        );
//
//        newProxyInstance.doWork();
//    }
//}
