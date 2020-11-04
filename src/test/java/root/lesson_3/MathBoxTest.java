package root.lesson_3;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class MathBoxTest {

    MathBox<Double> mathBox = new MathBox<>(asList(1d, 2d, 3d, 4d, 5d));

    @Test
    public void summator() {
        System.out.println("Изначальный объект:");
        mathBox.dump();
        System.out.println("HashCode объекта: " + mathBox.hashCode());
        System.out.println("---------------------------------------------------------");

        System.out.println("Добавляем дубликат:");
        mathBox.addObject(5d);
        mathBox.dump();
        System.out.println("HashCode объекта: " + mathBox.hashCode());
        System.out.println("---------------------------------------------------------");

        System.out.println("Добавляем новое число:");
        mathBox.addObject(6d);
        mathBox.dump();
        System.out.println("HashCode объекта: " + mathBox.hashCode());
        System.out.println("---------------------------------------------------------");

        System.out.println("Сумма всех чисел равна: " + mathBox.summator());
    }

    @Test
    public void splitter() {
        mathBox.deleteObject(5d);
        mathBox.dump();
        mathBox.splitter(3d);
        mathBox.dump();
    }

    @Test
    public void remove() {
        mathBox.remove(4);
        mathBox.dump();
    }
}