package root.lesson_2.task_3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Start {

    private static final Random RANDOM = new Random();
    private static final String STR = "adfvliudhjrmpivejvniursduivrnreiubtentrvwpnuitnuirbnpnrkfdlkmcvniprntbntrwb";

    final List<Person> personList = getPerson(10000);

    @Test
    public void testQuickSort() throws IncorrectPersonException {

        final List<Person> personListQuickSort = personList;

        MegaSort megaSortQuick = new QuickSortImpl();
        long startTimeSelectionSortQuick = System.currentTimeMillis();
        megaSortQuick.sort(personListQuickSort);
        long endTimeSelectionSortQuick = System.currentTimeMillis();
        personListQuickSort.forEach(System.out::println);
        System.out.println("Время работы быстрой сортировки: " +
                (endTimeSelectionSortQuick - startTimeSelectionSortQuick) + "ms");
    }

    @Test
    public void testBubbleSort() throws IncorrectPersonException {
        final List<Person> personListBubbleSort = personList;

        MegaSort megaSortBubble = new BubbleSortImpl();
        long startTimeSelectionSortBubble = System.currentTimeMillis();
        megaSortBubble.sort(personListBubbleSort);
        long endTimeSelectionSortBubble = System.currentTimeMillis();
        personListBubbleSort.forEach(System.out::println);
        System.out.println("Время работы сортировки пузырьком: " +
                (endTimeSelectionSortBubble - startTimeSelectionSortBubble) + "ms");

    }

    private List<Person> getPerson(int num) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            people.add(new Person((
                    RANDOM.nextInt(100)),
                    RANDOM.nextBoolean() ? Sex.MAN : Sex.WOMAN,
                    nextString(RANDOM.nextInt(STR.length() - 10))
            ));
        }
        return people;
    }

    private String nextString(int startIndex) {
        return STR.substring(startIndex);
    }
}
