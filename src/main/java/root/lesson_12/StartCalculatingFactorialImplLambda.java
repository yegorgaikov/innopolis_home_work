package root.lesson_12;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StartCalculatingFactorialImplLambda {
    private final List<Integer> list;
    private static final List<BigInteger> bigIntegerList = new ArrayList<>();
    private static final Map<Integer, BigInteger> map = new HashMap<>();

    public StartCalculatingFactorialImplLambda(List<Integer> list) {
        this.list = list;
    }

    public List<BigInteger> startMethod() throws ExecutionException, InterruptedException {
        StartCalculatingFactorial startCalculatingFactorial = (() -> {                 //Применение Lambda-expression
            ExecutorService service = Executors.newFixedThreadPool(list.size());

            for (Integer i : list) {
                CalculatingFactorialImplLambda calculatingFactorial = new CalculatingFactorialImplLambda(i, map);
                Future<BigInteger> future = service.submit(calculatingFactorial);
                bigIntegerList.add(future.get());
            }
            return bigIntegerList;
        });
        return startCalculatingFactorial.startThreads();
    }
}
