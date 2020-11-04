package root.lesson_7.task_2;

import org.junit.Test;

import java.util.List;
import java.util.Random;

public class ParagraphGeneratorImplTest {
    Random RANDOM = new Random();

    ArrayGenerator arrayGenerator = new ArrayGeneratorImpl();
    List<String> array = arrayGenerator.getArray();
    WordGenerator wordGenerator = new WordGeneratorImpl(array, RANDOM.nextInt(100));
    SentenceGenerator sentenceGenerator = new SentenceGeneratorImpl(wordGenerator);

    ParagraphGenerator paragraphGenerator = new ParagraphGeneratorImpl(sentenceGenerator);

    @Test
    public void getParagraph() {
        System.out.println("Сгенерированный абзац: " + paragraphGenerator.getParagraph());
    }
}