package main.java.lesson01.part2;

public class Task07 {

    /**
     * Самое нужное число
     * Закомментируй максимальное количество строк, чтобы на экран вывелось число 19
     * <p>
     * <p>
     * Требования:
     * 1. Программа должна выводить на экран число 19.
     * 2. Нельзя изменять строки с объявлением переменных.
     * 3. Нельзя изменять строку отвечающую за вывод в консоль.
     * 4. Нужно закомментировать некоторые строки и не менять остальные.
     */

    public static void main(String[] args) {
        int x = 1;
        int y = 0;

        y = y + 3 * x;
        //x = x * 2;
        x = x * 16; 
        //y = y + 2 * x;
        y = y + x;

        System.out.println(y);
    }

}
