package root.lesson_10;

//что-то с именами - сообразить

import java.lang.reflect.InvocationTargetException;

public class TestSomeClassCompiler {

    private static MyClassLoader loader = new MyClassLoader();

    public static void main(String[] args) throws Throwable {
        SomeClassCompiler someClassCompiler = new SomeClassCompiler();
        someClassCompiler.compile();

//        TestSomeClassCompiler test = new TestSomeClassCompiler();
//        test.invokeClassRuntime();


//        final Class<?> someClass = Class.forName("SomeClass", true, loader);
////        Method method = someClass.getMethod("doWork");
////        method.invoke(someClass.newInstance());
////        System.out.println(someClass);
//
////        Object object = getObject(loader);
//        method(someClass);
    }

    private static void method(Object obj){
        if (obj instanceof Worker){
            Worker worker = (Worker) obj;
            worker.doWork();
        }
    }

    private static Object getObject(ClassLoader classLoader){
        try {
            Class<?> clazz = classLoader.loadClass("SomeClass.java");
            return clazz.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException |
                IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}

/*
System.out.println("Hello world!");
System.out.println("Bonjour");
System.out.println("Shalom");
*/
