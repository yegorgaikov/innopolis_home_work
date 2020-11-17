package root.lesson_10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SomeClassWriter {

    public void writeSomeClass(List<String> linesList) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src\\main\\java\\root\\lesson_10\\SomeClass.java"))) {
            writer.write("package root.lesson_10;" + "\n" +
                    "public class SomeClass implements Worker{" + "\n" + " @Override" + "\n" +
                    "public void doWork() {" + "\n");
            for (String line : linesList) {
                writer.write(line + "\n");
            }
            writer.write("}"+ "\n" +"}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
