package root.lesson_2.task_3;

import java.util.List;

public class BubbleSortImpl implements MegaSort {

    @Override
    public <T extends Comparable<T>> void sort(List<T> list) throws IncorrectPersonException {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) == 0) {
                throw new IncorrectPersonException("Человек с такими данными уже есть");
            }
        }

        boolean needIteration = true;

        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                    needIteration = true;
                    T temp = list.get(i - 1);
                    list.set(i - 1, list.get(i));
                    list.set(i, temp);
                }

            }
        }
    }
}
