package root.lesson_10;

import org.junit.Test;

public class SomeClassWriterTest {

    public static void main(String[] args) {
        ConsoleReader cr = new ConsoleReader();
        SomeClassWriter writer = new SomeClassWriter();
        writer.writeSomeClass(cr.readLines());
    }
}

/*
System.out.println("Hello, world");
System.out.println("Bonjour, world");
System.out.println("Ola, world");
*/