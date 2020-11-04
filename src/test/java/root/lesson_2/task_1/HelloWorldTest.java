package root.lesson_2.task_1;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldTest {

    HelloWorld hw = new HelloWorld();

    @Test
    public void nullPointerExceptionMethod() {
        int[] array = null;
        System.out.println("Hello, World!");
        hw.nullPointerExceptionMethod(array);
    }

    @Test
    public void arrayIndexOutOfBoundsExceptionMethod() {
            System.out.println("Hello, World!");
            hw.arrayIndexOutOfBoundsExceptionMethod();
    }

    @Test
    public void myExceptionMethod() throws Exception {
            System.out.println("Hello, World!");
            hw.myExceptionMethod();
    }
}