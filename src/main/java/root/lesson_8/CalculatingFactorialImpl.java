package root.lesson_8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class CalculatingFactorialImpl implements CalculatingFactorial, Callable<BigInteger> {

    private static int num;
    private static Map<Integer, BigInteger> map;

    public CalculatingFactorialImpl(int num, Map<Integer, BigInteger> map) {
        this.num = num;
        this.map = map;
    }

    /**
     * Вычисление факториала.
     * Метод получает на вход число и коллекцию Map с уже посчитанными до этого факториалами.
     * Если число меньше нуля, то кидается исключение ArithmeticException, а если число 0 или 1, то его
     * факториал равен 1. Если число 2 и выше, то при подсчете первого числа, факториалы на каждой итерации
     * записываются в Map. Числа, которые подсчитываются далее имеют возможность сократить время умножения,
     * за счет уж вычисленных факториалов, записанных в Map. То есть, если мы вычисляем первое число
     * равное 5, то !2, !3, !4 и !5 записываются в Map, а при вычислении второго числа (например 7) мы берем
     * результат !5 из Map и далее умножаем его на 6, а потом на 7 и в итоге записываем в Map еще результаты
     * чисел !6, !7. Реализуется это так: в key Map записывается число, которое мы вычисляли, в value результат
     * его факториала. Когда на вход мы получаем новое число, то все числа по ключу в Map меньше нового числа
     * мы записываем в List, сортируем его и берем самое высокое уже вычисленное число, и факториал этого
     * числа умножаем на дальнейшие числа, чтобы получить факториал нового числа.
     */

    @Override
    public BigInteger factorial(int num, Map<Integer, BigInteger> map) {
        List<Integer> list = new ArrayList<>();
        BigInteger factorial;

        if (num < 0) {
            throw new ArithmeticException();
        } else if (num < 2) {
            factorial = BigInteger.ONE;
        } else {
            for (Integer key : map.keySet()) {
                if (key <= num) {
                    list.add(key);
                }
            }
            Collections.sort(list);
            System.out.println(list);

            BigInteger result;
            if (!list.isEmpty()) {
                result = map.get(list.get(list.size() - 1));
                int numNext = list.get(list.size() - 1) + 1;
                for (int i = numNext; i <= num; i++) {
                    result = result.multiply(BigInteger.valueOf(i));
                }
            } else {
                result = BigInteger.valueOf(1);
                for (int i = 2; i <= num; i++) {
                    result = result.multiply(BigInteger.valueOf(i));
                    map.put(i, result);
                }
            }
            factorial = result;
        }
        return factorial;
    }

    @Override
    public BigInteger call() throws Exception {
        return factorial(num, map);
    }
}
