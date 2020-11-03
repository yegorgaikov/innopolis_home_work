package root.lesson_2.task_1;

public class HelloWorld {

    int[] array = null;

    /**
     * Моделируем выброс исключения NullPointerException - передаем в аргументы метода пустой массив
     */
    void nullPointerExceptionMethod(int[] array) {
        array[0] = 0;
    }

    /**
     * Моделируем выброс исключения ArrayIndexOutOfBoundsException - создаем массив определенного размера
     * и пытаемся вызвать ячейку, номер которой больше размера массива
     */
    void arrayIndexOutOfBoundsExceptionMethod() {
        array = new int[2];

        System.out.println(array[2]);
    }

    /**
     * Моделируем выброс исключения с помощью оператора throw
     */
    void myExceptionMethod() throws Exception {
        throw new Exception();
    }
}
