package root.lesson_3;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObjectBoxTest {

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
    void addObject() {
        objectBox.addObject("Shalom");
        objectBox.dump();
    }

    @Test
    void deleteObject() {
        objectBox.deleteObject("Bonjour");
        objectBox.dump();
    }

    @Test
    void dump() {
    }
}