package lesson05.part05;

/**
 * Все лишнее - прочь!
 * Убрать в методе main() лишние строки, для которых метод add() не реализован.
 * <p>
 * <p>
 * Требования:
 * 1. В классе Solution должно быть реализовано три метода add().
 * 2. В методе main() нужно убрать лишние строки.
 * 3. Все методы класса Solution должны быть статическими.
 * 4. Все методы класса Solution должны быть публичными.
 */

public class Task10 {
    public static void main(String[] args) {
        add((short) 1, 2f);
        add(1, 2);
        add(2d, 2);
     //   add("1", 2d);
        add((byte) 1, 2d);
    }

    public static void add(int i, int j) {
        System.out.println("Integer addition");
    }

    public static void add(int i, double j) {
        System.out.println("Integer and double addition");
    }

    public static void add(double i, double j) {
        System.out.println("Double addition");
    }
}
