package root.lesson_12;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class StartCalculatingFactorialImplLambdaTest {

    List<Integer> list = new ArrayList<>();

    @Before
    public void init() {
        list.add(7);
        list.add(5);
        list.add(2);
        list.add(0);
        list.add(20);
        list.add(10);
    }

    @Test
    public void startThreads() throws ExecutionException, InterruptedException {
        StartCalculatingFactorialImplLambda start = new StartCalculatingFactorialImplLambda(list);

        System.out.println(start.startMethod());
    }

    @Test
    public void startThreadsWithNegativeNumber() throws ExecutionException, InterruptedException {
        list.add(-8);

        StartCalculatingFactorialImplLambda start = new StartCalculatingFactorialImplLambda(list);
        System.out.println(start.startMethod());
    }
}