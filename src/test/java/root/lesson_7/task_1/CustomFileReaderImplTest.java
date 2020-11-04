package root.lesson_7.task_1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomFileReaderImplTest {

    private final String pathInput = "src\\main\\java\\root\\lesson_7\\task_1\\song_lovefool.txt";
    private final String pathOutput = "src\\main\\java\\root\\lesson_7\\task_1\\word_list_of_song_lovefool.txt";

    CustomFileReader customFileReader = new CustomFileReaderImpl();
    List<String> list = new ArrayList<>();

    @Before
    public void init() {
        list = customFileReader.readAllLines(pathInput);
    }

    @Test
    public void readAllLines() {
        System.out.println(list);
    }

    @Test
    public void sort() {
        customFileReader.sort(list);
        System.out.println(list);
    }

    @Test
    public void writeListWords() {
        customFileReader.sort(list);
        customFileReader.writeListWords(list, pathOutput);
    }
}