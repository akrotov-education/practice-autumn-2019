package lesson05.part02;

/**
 * Три метода и минимум
 * Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
 * Каждый метод должен возвращать минимальное из двух переданных в него чисел.
 * <p>
 * <p>
 * Требования:
 * 1. Программа не должна выводить текст на экран.
 * 2. Класс задачи должен содержать четыре метода.
 * 3. Класс задачи должен содержать статический метод int min(int, int).
 * 4. Метод int min(int, int) должен возвращать минимальное из двух чисел типа int.
 * 5. Класс задачи должен содержать статический метод long min(long, long).
 * 6. Метод long min(long, long) должен возвращать минимальное из двух чисел типа long.
 * 7. Класс задачи должен содержать статический метод double min(double, double).
 * 8. Метод double min(double, double) должен возвращать минимальное из двух чисел типа double.
 */

public class Task09 {
    public static void main(String[] args) {
        int a = 0;
        int b = 999;

        long c = 0;
        long d = 999;

        double e = 0;
        double f = 999;

        min(a, b);
        min(c, d);
        min(e, f);
    }

    public static int min(int a, int b) {
        int min = Math.min(a, b);
        return min;
    }

    public static long min(long a, long b) {
        long min = Math.min(a, b);
        return min;
    }

    public static double min(double a, double b) {
        double min = Math.min(a, b);
        return min;
    }
}