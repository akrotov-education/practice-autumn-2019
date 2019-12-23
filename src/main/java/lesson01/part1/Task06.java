package lesson01.part1;

public class Task06 {

    /**
     * Выведи на экран длину окружности, рассчитанную по формуле: L = 2 * Pi * radius.
     * Результат - дробное число (тип double).
     * В качестве значения Pi используй значение 3.14.
     * <p>
     * <p>
     * Требования:
     * 1. В методе printCircleLength нужно вывести длину окружности, рассчитанную по формуле: 2 * Pi * radius.
     * 2. Метод main должен вызывать метод printCircleLength с параметром 5.
     * 3. Метод main не должен вызывать команду вывода текста на экран.
     * 4. Программа должна выводить длину окружности с радиусом 5.
     */

    public static void main(String[] args) {
        printCircleLength(5);
    }

    public static void printCircleLength(int radius) {
        double L = 2 * 3.14 * radius;
        System.out.println(L);
    }

}
