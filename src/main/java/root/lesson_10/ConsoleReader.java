package root.lesson_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader {

    public List<String> readLines() {
        List <String> linesList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line ;
        while (!(line = scanner.nextLine()).isEmpty()){
            linesList.add(line);
        }
        return linesList;
    }
}
