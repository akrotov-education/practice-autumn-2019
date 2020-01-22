package lesson05.part02;

/**
 * Int и Integer
 * Написать два метода: print(int) и print(Integer).
 * Написать такой код в методе main, чтобы вызвались они оба.
 * <p>
 * <p>
 * Требования:
 * 1. Класс Solution должен содержать статический метод main().
 * 2. Класс Solution должен содержать статический void метод print() с параметром типа int.
 * 3. Класс Solution должен содержать статический void метод print() с параметром типа Integer.
 * 4. Метод main() должен вызывать метод print() с параметром типа int.
 * 5. Метод main() должен вызывать метод print() с параметром типа Integer.
 */

public class Task07 {
    public static void main(String[] args) {
        int a = 5;
        Integer b = 5;
        print(a);
        print(b);
    }

    public static void print(int a) {
        System.out.println("int");
    }

    public static void print(Integer a) {
        System.out.println("Integer");
    }
}
