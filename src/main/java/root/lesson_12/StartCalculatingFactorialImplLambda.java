package root.lesson_12;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class StartCalculatingFactorialImplLambda {
    private final List<Integer> list;
    private static final List<Future<BigInteger>> futuresList = new ArrayList<>();
    private static final List<BigInteger> bigIntegerList = new ArrayList<>();
    private static final Map<Integer, BigInteger> map = new ConcurrentHashMap<>();

    public StartCalculatingFactorialImplLambda(List<Integer> list) {
        this.list = list;
    }

    public List<BigInteger> startMethod() throws ExecutionException, InterruptedException {
        StartCalculatingFactorial startCalculatingFactorial = (() -> {                 //Применение Lambda-expression
            ExecutorService service = Executors.newFixedThreadPool(list.size());

            for (Integer i : list) {
                CalculatingFactorialImplLambda calculatingFactorial = new CalculatingFactorialImplLambda(i, map);
                Future<BigInteger> future = service.submit(calculatingFactorial);
                futuresList.add(future);
            }

            for (Future<BigInteger> f : futuresList) {
                bigIntegerList.add(f.get());
            }
            return bigIntegerList;
        });
        return startCalculatingFactorial.startThreads();
    }
}
