package root.lesson_8;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface StartCalculatingFactorial {
    public List<BigInteger> startThreads () throws ExecutionException, InterruptedException;
}
