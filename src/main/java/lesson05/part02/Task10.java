package lesson05.part02;

/**
 * Три метода и максимум
 * Написать public static методы: int max(int, int), long max(long, long), double max(double, double).
 * Каждый метод должен возвращать максимальное из двух переданных в него чисел.
 * <p>
 * <p>
 * Требования:
 * 1. Программа не должна выводить текст на экран.
 * 2. Класс задачи должен содержать четыре метода.
 * 3. Класс задачи должен содержать статический метод int max(int, int).
 * 4. Метод int max(int, int) должен возвращать максимальное из двух чисел типа int.
 * 5. Класс задачи должен содержать статический метод long max(long, long).
 * 6. Метод long max(long, long) должен возвращать максимальное из двух чисел типа long.
 * 7. Класс задачи должен содержать статический метод double max(double, double).
 * 8. Метод double max(double, double) должен возвращать максимальное из двух чисел типа double.
 */

public class Task10 {
    public static void main(String[] args) {

        int a = 0;
        int b = 999;

        long c = 0;
        long d = 999;

        double e = 0;
        double f = 999;

        max(a, b);
        max(c, d);
        max(e, f);
    }

    public static int max(int a, int b) {
        int max = Math.max(a, b);
        return max;
    }

    public static long max(long a, long b) {
        long max = Math.max(a, b);
        return max;
    }

    public static double max(double a, double b) {
        double max = Math.max(a, b);
        return max;
    }
}