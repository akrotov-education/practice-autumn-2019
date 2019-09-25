package lesson01.part1;

public class Task04 {

    /**
     * Раскомментируй одну строчку, чтобы программа вывела на экран числа 26 и 25.
     * <p>
     * Требования:
     * 1. Программа должна выводить на экран числа 26 и 25.
     * 2. Нужно раскомментировать одну строку.
     * 3. Нельзя изменять (добавлять, удалять) строки с кодом.
     */

    public static void main(String[] args) {

        int x = 27;
        int y = 15;

        // y = x - y;
        // y = y - x;
        // y = y + x;
        // y = y + x;
        y = x / y;
        // y = y / x;
        // y = y * x;

        x = x - y;
        y = y - x;

        System.out.println(Math.abs(x));
        System.out.println(Math.abs(y));
    }
}
