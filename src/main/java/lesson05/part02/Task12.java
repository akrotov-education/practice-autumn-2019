package lesson05.part02;

/**
 * «Исправь код», часть 1
 * Расскомментируй, затем исправь код, чтобы программа компилировалась.
 * <p>
 * Подсказка:
 * метод getChild должен остаться абстрактным.
 * <p>
 * <p>
 * Требования:
 * 1. Класс Pet должен быть статическим.
 * 2. Класс Pet должен иметь два метода.
 * 3. Метод getChild() должен быть абстрактным.
 * 4. Класс Pet должен быть объявлен с модификатором, который запрещает создавать конкретные объекты этого класса.
 */

public class Task12 {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public String getName() {
            return "Я - котенок";
        }

        public abstract Pet getChild();
    }
}
