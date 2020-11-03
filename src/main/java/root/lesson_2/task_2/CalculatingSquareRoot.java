package root.lesson_2.task_2;

import java.util.Random;

public class CalculatingSquareRoot {

    static int countNegative = 0;

    public static void main(String[] args) {

        int max = 10000;
        int minN = 1;
        int minK = -10000;
        int diffN = max - minN;
        int diffK = max - minK;

        Random random = new Random();
        int n = random.nextInt(diffN + 1) + minN;

        for (int i = 0; i < n; i++) {
            int k = random.nextInt(diffK + 1) + minK;

            try {
                if (k < 0) {
                    throw new ArithmeticException();
                }
            } catch (ArithmeticException ae) {
                countNegative++;
                continue;
            }

            double q = Math.sqrt(k);
            if ((int) q * q == k) {
                System.out.println((int) q);
            }
        }

        System.out.println("Общее количество случайных чисел: " + n + ", " +
                "среди них отрицательных чисел: " + countNegative);
    }
}
