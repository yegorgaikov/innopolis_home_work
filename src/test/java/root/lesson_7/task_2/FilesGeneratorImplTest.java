package root.lesson_7.task_2;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class FilesGeneratorImplTest {
    ArrayGenerator arrayGenerator = new ArrayGeneratorImpl();
    List<String> array = arrayGenerator.getArray();

    FilesGenerator filesGenerator = new FilesGeneratorImpl();

    @Test
    public void getFiles() throws IOException {
        filesGenerator.getFiles(
                "src\\main\\java\\root\\lesson_7\\task_2\\generate_text_files",
                3,
                4,
                array,
                50
        );
    }
}