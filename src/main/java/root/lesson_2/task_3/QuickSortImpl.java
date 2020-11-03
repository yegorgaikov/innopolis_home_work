package root.lesson_2.task_3;

import java.util.Collections;
import java.util.List;

public class QuickSortImpl implements MegaSort {

    @Override
    public <T extends Comparable<T>> void sort(List<T> list) throws IncorrectPersonException {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) == 0) {
                throw new IncorrectPersonException("Человек с такими данными уже есть");
            }
        }
        Collections.sort(list);
    }
}
