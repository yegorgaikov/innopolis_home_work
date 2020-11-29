package root.lesson_13;

import javassist.ClassPool;

public class OutOfMemoryErrorMetaspace {

    static ClassPool classPool = ClassPool.getDefault();

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 1_000_000_000; i++) {
            Class clazz = classPool.makeClass(i + " OutOfMemoryErrorMetaspace ").toClass();
            System.out.println(clazz.getName());
        }
    }
}
