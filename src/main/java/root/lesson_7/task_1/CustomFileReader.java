package root.lesson_7.task_1;

import java.util.List;

public interface CustomFileReader {

    List<String> readAllLines(String path);

    List<String> sort(List<String> list);

    void writeListWords(List<String> list, String path);
}
