package root.lesson_7.task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordGeneratorImpl implements WordGenerator {

    /**
     * Генерация слова.
     * В слове от 1 до 15 букв.
     * Есть массив слов размером от 1 до 1000 слов, есть вероятность probability вхождения одного из слов этого
     * массива в следующее предложение. Рандомно генерируем число от 0 до 100, если это число больше вероятности,
     * то генерируем рандомное слова методом getRandomWord(), если меньше, то берем слово из массива методом
     * fromArrayWord().
     */
    private static final int MAX_LENGTH = 15;
    private static final int MIN_LENGTH = 1;
    private static final Random RANDOM = new Random();
    private final List<String> array;
    private final int probability;

    //Строчные буквы из Unicode
    private static final int MINLOWER = 97;
    private static final int MAXLOWER = 122;
    private static final int DIFFLOWER = MAXLOWER - MINLOWER;

    //Заглавные буквы из Unicode
    private static final int MINUPPER = 65;
    private static final int MAXUPPER = 90;
    private static final int DIFFUPPER = MAXUPPER - MINUPPER;

    public WordGeneratorImpl(List<String> array, int probability) {
        this.array = array;
        this.probability = probability;
    }

    @Override
    public String getWord() {
        if (probability < RANDOM.nextInt(100)) {
            return getRandomWord();
        }
        return fromArrayWord();
    }

    private String getRandomWord() {
        int lengthWord = RANDOM.nextInt(MAX_LENGTH) + MIN_LENGTH;
        StringBuilder sbWord = new StringBuilder();

        /*
          При генерации слова закладываем условие - если первая буква - то она должна быть заглавной (входят
          в диапазон Unicode от 65 до 90), остальные буквы - строчные (входят в диапазон Unicode от 97 до 122).
          Далее при создании предложения - если слово идет первое, то ничего не делаем, а дальнейшие слова
          переводим в нижний регистр методом toLowerCase().
         */
        for (int i = 0; i < lengthWord; i++) {
            int symbol;
            if (i == 0) {
                symbol = RANDOM.nextInt(DIFFUPPER + 1);
                symbol += MINUPPER;
            } else {
                symbol = RANDOM.nextInt(DIFFLOWER + 1);
                symbol += MINLOWER;
            }
            sbWord.append((char) symbol);
        }
        return new String(sbWord);
    }

    /**
     * В массиве могут быть любые слова и не известно какого регистра. Для того чтобы метод fromArrayWord()
     * выдавал слово с первой заглавной буквой и остальными строчными, переводим слово, которое рандомно взято
     * из массива в нижний регистр, раскладываем его на символы и записываем в локальный массив посимвольно,
     * далее первый элемент этого массива переводим в верхний регистр и потом собираем обратно слово по символам
     * в один String с помощью StringBuilder и его метода append().
     */
    private String fromArrayWord() {
        int i = RANDOM.nextInt(array.size());
        String word = array.get(i).toLowerCase();
        List<Character> list = new ArrayList<>();

        for (int j = 0; j < word.length(); j++) {
            list.add(word.charAt(j));
        }
        String firstChar = String.valueOf(list.get(0)).toUpperCase();
        list.set(0, firstChar.charAt(0));

        StringBuilder sb = new StringBuilder();

        for (Character character : list) {
            sb.append(character);
        }
        return new String(sb);
    }
}
