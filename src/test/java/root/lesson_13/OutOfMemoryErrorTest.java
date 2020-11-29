package root.lesson_13;

import org.junit.Test;

public class OutOfMemoryErrorTest {

    OutOfMemoryError outOfMemoryError = new OutOfMemoryError();

    @Test
    public void add() {
        outOfMemoryError.add();
    }
}