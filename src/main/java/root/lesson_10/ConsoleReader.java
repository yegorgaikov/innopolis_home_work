//package root.lesson_10;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class ConsoleReader {
//
//    public List<String> readLines() {
//        List <String> linesList = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        String line ;
//        while (!(line = scanner.nextLine()).isEmpty()){
//            linesList.add(line);
//        }
//        return linesList;
//    }
//}

//public void buildSomeClass(List<String> linesList) {
//        try (BufferedWriter writer = new BufferedWriter(
//        new FileWriter(path))) {
//        writer.write("package root.lesson_10;"
//        + "\n"
//        + "public class SomeClass implements Worker{"
//        + "\n"
//        + "@Override"
//        + "\n"
//        + "public void doWork() {"
//        + "\n");
//
//        for (String line : linesList) {
//        writer.write(line + "\n");
//        }
//        writer.write("}" + "\n" + "}");
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
