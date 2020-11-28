package root.lesson_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    private static List<Object> list = new ArrayList<>();

    public void add() {
        for (int i = 1; i < 2_000_000_000; i++) {
            list.add(new MyObject(i));
            if (i % 100 == 0) {
                remove();
            }
        }
    }

    public void remove() {
        Random random = new Random();
        int sizeRemove = random.nextInt(50);

        for (int i = 0; i < sizeRemove; i++) {
            list.remove(i);
        }
    }
}
