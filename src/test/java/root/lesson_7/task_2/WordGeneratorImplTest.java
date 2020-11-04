package root.lesson_7.task_2;

import org.junit.Test;

import java.util.List;
import java.util.Random;

public class WordGeneratorImplTest {

    final static Random RANDOM = new Random();
    ArrayGenerator arrayGenerator = new ArrayGeneratorImpl();
    List<String> array = arrayGenerator.getArray();

    WordGenerator wordGenerator = new WordGeneratorImpl(array, RANDOM.nextInt(100));

    @Test
    public void getWord() {
        //Проверяем создается ли массив и какого размера
        System.out.println("Массив слов:" + array);
        System.out.println("Размер массива: " + array.size());

        //Генерируем слово
        String word = wordGenerator.getWord();
        System.out.println("Сгенерированное слово: " + word);
        System.out.println("Длина слова: " + word.length());
    }
}