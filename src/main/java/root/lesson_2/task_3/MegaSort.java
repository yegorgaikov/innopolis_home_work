package root.lesson_2.task_3;

import java.util.List;

public interface MegaSort {
    <T extends Comparable<T>> void sort(List<T> list) throws IncorrectPersonException;
}
