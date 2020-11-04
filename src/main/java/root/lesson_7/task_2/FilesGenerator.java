package root.lesson_7.task_2;

import java.io.IOException;
import java.util.List;

public interface FilesGenerator {
    void getFiles(String path, int n, int size, List<String> words, int probability) throws IOException;
}
