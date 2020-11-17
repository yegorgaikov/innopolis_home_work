package root.lesson_8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class StartCalculatingFactorialImpl implements StartCalculatingFactorial {
    private final List<Integer> list;
    private static final List<Future<BigInteger>> futuresList = new ArrayList<>();
    private static final List<BigInteger> bigIntegerList = new ArrayList<>();
    private static final Map<Integer, BigInteger> map = new ConcurrentHashMap<>();

    public StartCalculatingFactorialImpl(List<Integer> list) {
        this.list = list;
    }

    @Override
    public List<BigInteger> startThreads() throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(list.size());

        for (Integer i : list) {
            CalculatingFactorialImpl calculatingFactorial = new CalculatingFactorialImpl(i, map);
            Future<BigInteger> future = service.submit(calculatingFactorial);
            futuresList.add(future);
        }

        for (Future<BigInteger> f : futuresList) {
            bigIntegerList.add(f.get());
        }

        return bigIntegerList;
    }

}
