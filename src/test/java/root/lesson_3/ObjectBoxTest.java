package root.lesson_3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ObjectBoxTest {

    ObjectBox<String> objectBox = new ObjectBox<>(init());

    @Before
    List<String> init() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("Privet");
        arrayList.add("Bonjour");

        return arrayList;
    }

    @Test
    public void addObject() {
        objectBox.addObject("Shalom");
        objectBox.dump();
    }

    @Test
    public void deleteObject() {
        objectBox.deleteObject("Bonjour");
        objectBox.dump();
    }

    @Test
    public void dump() {
    }
}