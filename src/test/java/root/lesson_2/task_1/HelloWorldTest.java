package root.lesson_2.task_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    HelloWorld hw = new HelloWorld();

    @Test
    void nullPointerExceptionMethod() {
        int[] array = null;
        System.out.println("Hello, World!");
        hw.nullPointerExceptionMethod(array);
    }

    @Test
    void arrayIndexOutOfBoundsExceptionMethod() {
        System.out.println("Hello, World!");
        hw.arrayIndexOutOfBoundsExceptionMethod();
    }

    @Test
    void myExceptionMethod() throws Exception {
        System.out.println("Hello, World!");
        hw.myExceptionMethod();
    }
}