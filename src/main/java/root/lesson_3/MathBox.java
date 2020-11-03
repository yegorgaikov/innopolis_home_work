package root.lesson_3;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MathBox<T extends Number> extends ObjectBox<T> {

    public MathBox(List<T> array) {
        super(new HashSet<T>(array));
    }

    public Number summator() {
        double sum = 0;
        for (T elem : getBuffer()) {
            sum += elem.doubleValue();
        }
        return sum;
    }

    public void splitter(double divider) {
        Set<T> doubles = new HashSet<>();
        for (T elem : getBuffer()) {
            Double res = elem.doubleValue() / divider;
            doubles.add((T) res);
        }
        getBuffer().addAll(doubles);
    }

    public void remove(Integer value) {
        getBuffer().removeIf(elem -> Objects.equals(elem.intValue(), value));
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "buffer=" + getBuffer() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox<?> mathBox = (MathBox<?>) o;
        return Objects.equals(getBuffer(), mathBox.getBuffer());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
