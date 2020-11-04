package root.lesson_7.task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayGeneratorImpl implements ArrayGenerator {

    Random RANDOM = new Random();

    /**
     * Генерация массива слов.
     * Массив имеет размер от 1 до 1000 слов.
     */
    @Override
    public List<String> getArray() {
        final int MAX_LENGTH_WORD = 15;
        final int MAX_LENGTH_ARRAY = 1000;
        final int MIN_LENGTH = 1;

        int arrayLength = RANDOM.nextInt(MAX_LENGTH_ARRAY) + MIN_LENGTH;
        List<String> array = new ArrayList<>(arrayLength);

        for (int i = 0; i < arrayLength; i++) {
            //Строчные буквы из Unicode
            final int MINLOWER = 97;
            final int MAXLOWER = 122;
            final int DIFFLOWER = MAXLOWER - MINLOWER;

            //Заглавные буквы из Unicode
            final int MINUPPER = 65;
            final int MAXUPPER = 90;
            final int DIFFUPPER = MAXUPPER - MINUPPER;

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
