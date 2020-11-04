package root.lesson_7.task_2;

import java.util.Random;

public class ParagraphGeneratorImpl implements ParagraphGenerator {

    /**
     * Генерация абзаца.
     * В абзаце от 1 до 20 предложений.
     */
    private static final int MAX_LENGTH = 20;
    private static final int MIN_LENGTH = 1;
    private static final String linefeed = "\n";

    Random RANDOM = new Random();
    private final SentenceGenerator sentenceGenerator;

    public ParagraphGeneratorImpl(SentenceGenerator sentenceGenerator) {
        this.sentenceGenerator = sentenceGenerator;
    }

    @Override
    public String getParagraph() {
        int lengthParagraph = RANDOM.nextInt(MAX_LENGTH) + MIN_LENGTH;
        StringBuilder sbParagraph = new StringBuilder();

        for (int i = 0; i < lengthParagraph; i++) {
            if (i == (lengthParagraph - 1)) {
                sbParagraph.append(sentenceGenerator.getSentence()).append(linefeed);
            } else {
                sbParagraph.append(sentenceGenerator.getSentence());
            }
        }
        return new String(sbParagraph);
    }
}
