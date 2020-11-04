package root.lesson_7.task_2;

import org.junit.Test;

import java.util.List;
import java.util.Random;

public class SentenceGeneratorImplTest {

    Random RANDOM = new Random();

    ArrayGenerator arrayGenerator = new ArrayGeneratorImpl();
    List<String> array = arrayGenerator.getArray();
    WordGenerator wordGenerator = new WordGeneratorImpl(array, RANDOM.nextInt(100));

    SentenceGenerator sentenceGenerator = new SentenceGeneratorImpl(wordGenerator);

    @Test
    public void getSentence() {
        System.out.println("Сгенерированное предложение: " + sentenceGenerator.getSentence());
    }
}