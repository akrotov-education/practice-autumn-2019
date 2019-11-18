package lesson05.part05;

/**
 * Что-то лишнее
 * 1. Программа должна выводить следующее:
 * Это double
 * Это Object
 * Это double
 * Это Integer
 * Это double
 * <p>
 * 2. Удали реализации всех лишних методов
 * <p>
 * <p>
 * Требования:
 * 1. В классе Solution должен остаться метод print с одним параметром типа Integer.
 * 2. В классе Solution должен остаться метод print с одним параметром типа Object.
 * 3. В классе Solution должен остаться метод print с одним параметром типа double.
 * 4. Вывод на экран должен соответствовать условию.
 */

public class Task06 {
    public static void main(String[] args) {
        print((short) 1);
        print((Number) 1);
        print(1);
        print((Integer) 1);
        print(1);
    }

    public static void print(Integer i) {
        System.out.println("Это Integer");
    }

    public static void print(int i) {
        System.out.println("Это Integer");
    }

    public static void print(Short i) {
        System.out.println("Это Object");
    }

    public static void print(Object i) {
        System.out.println("Это Object");
    }

    public static void print(double i) {
        System.out.println("Это double");
    }

    public static void print(Double i) {
        System.out.println("Это double");
    }

    public static void print(float i) {
        System.out.println("Это Double");
    }
}
