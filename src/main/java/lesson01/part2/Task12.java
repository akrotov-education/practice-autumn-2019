package lesson01.part2;

public class Task12 {

    /**
     * Написать функцию, которая вычисляет минимум из четырёх чисел.
     * Функция min(a,b,c,d) должна использовать (вызывать) функцию min(a,b)
     * <p>
     * Подсказка:
     * Нужно написать тело двух существующих функций min.
     * <p>
     * <p>
     * Требования:
     * 1. Программа должна выводить текст на экран.
     * 2. Методы min не должны выводить текст на экран.
     * 3. Метод main должен вызывать метод min(a, b) и метод min(a, b, c, d).
     * 4. Метод main должен выводить на экран результат работы методов min. Каждый раз с новой строки.
     * 5. Метод min(a, b) должен возвращать минимальное значение из чисел a, b.
     * 6. Метод min(a, b, c, d) должен использовать метод min(a, b)
     * 7. Метод min(a, b, c, d) должен возвращать минимальное значение из чисел a, b, c, d.
     */

    public static int min(int a, int b, int c, int d) {
        //напишите тут ваш код
        return 0;
    }

    public static int min(int a, int b) {
        //напишите тут ваш код
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(-20, -10));
        System.out.println(min(-40, -10, -30, 40));
        System.out.println(min(-20, -40, -30, 40));
        System.out.println(min(-20, -10, -40, 40));
        System.out.println(min(-20, -10, -30, -40));
    }
}
