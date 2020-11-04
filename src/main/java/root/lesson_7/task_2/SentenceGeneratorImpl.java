package root.lesson_7.task_2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SentenceGeneratorImpl implements SentenceGenerator {

    private static final int MAX_LENGTH = 15;
    private static final int MIN_LENGTH = 1;
    private static final List<String> ENDS = Arrays.asList(".", "!", "?", "");
    private static final Random RANDOM = new Random();
    private final WordGenerator wordGenerator;

    public SentenceGeneratorImpl(WordGenerator wordGenerator) {
        this.wordGenerator = wordGenerator;
    }

    @Override
    public String getSentence() {

        int lengthSentence = RANDOM.nextInt(MAX_LENGTH) + MIN_LENGTH;
        StringBuilder sbSentence = new StringBuilder();

        /*
          При создании предложения - если слово идет первое, то ничего не делаем, а дальнейшие слова
          переводим в нижний регистр методом toLowerCase(). И включаем условие - если предложение не
          состоит из одного слова или слово не идет последним, то генерируется возможность наличия запятой
          после слова (с вероятностью 1/4)
         */
        for (int i = 0; i < lengthSentence; i++) {
            if (i == 0) {
                sbSentence.append(wordGenerator.getWord());
                if (RANDOM.nextInt(4) == 1 && lengthSentence != 1) {
                    sbSentence.append(',');
                }
            } else {
                sbSentence.append(' ').append(wordGenerator.getWord().toLowerCase());
                if (RANDOM.nextInt(4) == 1 && i != (lengthSentence - 1)) {
                    sbSentence.append(',');
                }
            }
        }

        int punctuationMark = RANDOM.nextInt(4);
        if (punctuationMark == 0) {
            sbSentence.append(ENDS.get(punctuationMark));
        } else if (punctuationMark == 1) {
            sbSentence.append(ENDS.get(punctuationMark));
        } else if (punctuationMark == 2) {
            sbSentence.append(ENDS.get(punctuationMark));
        } else {
            sbSentence.append(ENDS.get(punctuationMark));
        }
        return new String(sbSentence);
    }
}
