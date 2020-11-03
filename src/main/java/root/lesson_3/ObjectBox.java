package root.lesson_3;

import java.util.Collection;
import java.util.Objects;
import java.util.Random;

public class ObjectBox<T> {

    private int hashCode = -1;
    private final Collection<T> buffer;

    public ObjectBox(Collection<T> objects) {
        this.buffer = objects;
    }

    public void addObject(T obj) {
        buffer.add(obj);
    }

    public void deleteObject(T obj) {
        buffer.remove(obj);
    }

    public void dump() {
        System.out.println(buffer);
    }

    public Collection<T> getBuffer() {
        return buffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectBox<?> objectBox = (ObjectBox<?>) o;
        return Objects.equals(buffer, objectBox.buffer);
    }

    @Override
    public int hashCode() {
        if (hashCode == -1) {
            hashCode = new Random().nextInt();
        }
        return hashCode;
    }
}
