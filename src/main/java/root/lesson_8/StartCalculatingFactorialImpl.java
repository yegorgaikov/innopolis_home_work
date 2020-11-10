package root.lesson_8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StartCalculatingFactorialImpl implements StartCalculatingFactorial {
    private final List<Integer> list;
    private static final List<BigInteger> bigIntegerList = new ArrayList<>();
    private static final Map<Integer, BigInteger> map = new HashMap<>();

    public StartCalculatingFactorialImpl(List<Integer> list) {
        this.list = list;
    }

    @Override
    public List<BigInteger> startThreads() throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(list.size());

        for (Integer i : list) {
            CalculatingFactorialImpl calculatingFactorial = new CalculatingFactorialImpl(i, map);
            Future<BigInteger> future = service.submit(calculatingFactorial);
            bigIntegerList.add(future.get());
        }
        return bigIntegerList;
    }

}
