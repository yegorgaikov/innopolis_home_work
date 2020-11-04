package root.lesson_7.task_2;

import java.util.Random;

public class ParagraphGeneratorImpl implements ParagraphGenerator {

    private static final int MAX_LENGTH = 20;
    private static final int MIN_LENGTH = 1;

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
                sbParagraph.append(sentenceGenerator.getSentence()).append("\n");
            } else {
                sbParagraph.append(sentenceGenerator.getSentence()).append(" ");
            }
        }
        return new String(sbParagraph);
    }
}
