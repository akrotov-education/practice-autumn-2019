package lesson05.part04;

/**
 * Реализовать метод printMainInfo
 * 1. Напиши реализацию метода printMainInfo, чтобы:
 * 1.1. Если в метод передают объект типа Drawable, у этого объекта вызывался метод draw.
 * 1.2. Если в метод передают объект типа Movable, у этого объекта вызывался метод move.
 * <p>
 * <p>
 * Требования:
 * 1. Класс Solution должен содержать реализацию метода printMainInfo с одним параметром типа Object.
 * 2. Метод printMainInfo должен быть статическим.
 * 3. Метод printMainInfo должен иметь самый широкий уровень доступа(public).
 * 4. Метод printMainInfo должен вызывать у переданного ему в качестве параметра объекта метод draw, если этот объект реализует интерфейс Drawable.
 * 5. Метод printMainInfo должен вызывать у переданного ему в качестве параметра объекта метод move, если этот объект реализует интерфейс Movable.
 */

public class Task11 {
    public static void main(String[] args) {
        Object obj = new Circle();
        Movable movable = (Movable) obj;
        Drawable drawable = new Rectangle();

        printMainInfo(drawable);
        printMainInfo(movable);
    }

    public static void printMainInfo(Object object) {
        //напишите тут ваш код
    }

    static interface Movable {

        void move();
    }

    static class Circle implements Movable {

        public void draw() {
            System.out.println("Can be drawn");
        }

        public void move() {
            System.out.println("Can be moved");
        }

    }

    static interface Drawable {
        void draw();
    }

    static class Rectangle implements Drawable {
        public void draw() {
            System.out.println("Can be drawn");
        }

        public void move() {
            System.out.println("Can be moved");
        }
    }
}
