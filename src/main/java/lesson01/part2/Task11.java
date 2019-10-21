package lesson01.part2;

public class Task11 {

    /**
     * Написать функцию, которая вычисляет минимум из трёх чисел.
     * <p>
     * Подсказка:
     * Нужно написать тело существующей функции min.
     * <p>
     * <p>
     * Требования:
     * 1. Программа должна выводить текст на экран.
     * 2. Метод min не должен выводить текст на экран.
     * 3. Метод main должен вызвать метод min четыре раза.
     * 4. Метод main должен выводить на экран результат работы метода min. Каждый раз с новой строки.
     * 5. Метод min должен возвращать минимальное значение из чисел a, b и с.
     */

    public static int min(int a, int b, int c) {
        //напишите тут ваш код
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(5, 5, 10));
    }

}
