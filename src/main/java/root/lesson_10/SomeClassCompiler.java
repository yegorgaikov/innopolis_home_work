package root.lesson_10;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SomeClassCompiler {

    private String path = "src\\main\\java\\root\\lesson_10\\SomeClass.java";
    private StringBuilder builder;

    public SomeClassCompiler() {
        builder = new StringBuilder();
    }

    void compile() {
        String codeClass = buildSomeClass();
        javac(codeClass);
    }

    private void javac(String codeClass) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(codeClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        javaCompiler.run(null, null,null, path);
    }


    public String buildSomeClass() {
        builder.append("package root.lesson_10;"
                + "\n"
                + "public class SomeClass implements Worker{"
                + "\n"
                + "@Override"
                + "\n"
                + "public void doWork() {"
                + "\n");

        List<String> linesList = readLines();

        for (String line : linesList) {
            builder.append(line).append("\n");
        }

        builder.append("}" + "\n" + "}");

        return builder.toString();
    }

    public List<String> readLines() {
        List<String> linesList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            linesList.add(line);
        }
        return linesList;
    }
}
