package root.lesson_7.task_2;

import java.util.Arrays;
import java.util.List;

public class SentenceGeneratorImpl implements SentenceGenerator {

    private static final int MAX_LENGTH = 15;
    private static final int MIN_LENGTH = 1;
    private static final List<String> ENDS = Arrays.asList(".", "!", "?", "");
    private final WordGenerator wordGenerator;

    public SentenceGeneratorImpl(WordGenerator wordGenerator) {
        this.wordGenerator = wordGenerator;
    }

    @Override
    public String getSentence() {
        wordGenerator.getWord();
        return null;
    }
}
