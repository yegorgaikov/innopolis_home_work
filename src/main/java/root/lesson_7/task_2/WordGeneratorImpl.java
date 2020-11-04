package root.lesson_7.task_2;

import java.util.List;
import java.util.Random;

public class WordGeneratorImpl implements WordGenerator {

    private static final Random RANDOM = new Random();
    private final List<String> array;
    private final int probability;

    public WordGeneratorImpl(List <String> array, int probability) {
        this.array =array;
        this.probability = probability;
    }

    @Override
    public String getWord() {
        if(probability < RANDOM.nextInt(100)){   //проверить 100-проценты
            return getRandomWord();
        }
        return fromArrayWord();
    }

    private String getRandomWord() {
        return null;
    }

    private String fromArrayWord(){
        return null;
    }
}
