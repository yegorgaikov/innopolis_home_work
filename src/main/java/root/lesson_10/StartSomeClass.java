package root.lesson_10;

public class StartSomeClass {

    private static final String name = "SomeClass";

    private static MyClassLoader loader = new MyClassLoader();

    public static void main(String[] args) throws Throwable {
        Compiler someClassCompiler = new Compiler();
        someClassCompiler.compile();

        final Class<?> someClass = Class.forName(name, true, loader);
        method(someClass);
    }

    private static void method(Object obj) {
        if (obj instanceof Worker) {
            Worker worker = (Worker) obj;
            worker.doWork();
        }
    }
}

/*
Пишем в консоль, для создания тела метода doWork():

System.out.println("Hello world!");
System.out.println("Bonjour");
System.out.println("Shalom");
*/
