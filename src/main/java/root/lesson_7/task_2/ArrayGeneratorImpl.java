package root.lesson_7.task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayGeneratorImpl implements ArrayGenerator {

    private static Random RANDOM = new Random();
    private static final int MAX_LENGTH_WORD = 15;
    private static final int MAX_LENGTH_ARRAY = 1000;
    private static final int MIN_LENGTH = 1;

    //Строчные буквы из Unicode
    private static final int MINLOWER = 97;
    private static final int MAXLOWER = 122;
    private static final int DIFFLOWER = MAXLOWER - MINLOWER;

    //Заглавные буквы из Unicode
    private static final int MINUPPER = 65;
    private static final int MAXUPPER = 90;
    private static final int DIFFUPPER = MAXUPPER - MINUPPER;

    /**
     * Генерация массива слов.
     * Массив имеет размер от 1 до 1000 слов.
     */
    @Override
    public List<String> getArray() {
        int arrayLength = RANDOM.nextInt(MAX_LENGTH_ARRAY) + MIN_LENGTH;
        List<String> array = new ArrayList<>(arrayLength);

        for (int i = 0; i < arrayLength; i++) {
            int lengthWord = RANDOM.nextInt(MAX_LENGTH_WORD) + MIN_LENGTH;
            StringBuilder sbWord = new StringBuilder();

            for (int j = 0; j < lengthWord; j++) {
                int symbol;
                if (j == 0) {
                    symbol = RANDOM.nextInt(DIFFUPPER + 1);
                    symbol += MINUPPER;
                } else {
                    symbol = RANDOM.nextInt(DIFFLOWER + 1);
                    symbol += MINLOWER;
                }
                sbWord.append((char) symbol);
            }
            array.add(new String(sbWord));
        }
        return array;
    }
}
