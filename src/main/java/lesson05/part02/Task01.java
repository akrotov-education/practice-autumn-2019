package lesson05.part02;

/**
 * Киты и коровы
 * Переопределить метод getName в классе Whale(Кит), чтобы программа выдавала:
 * <p>
 * Я не корова, Я - кит.
 * <p>
 * <p>
 * Требования:
 * 1. Программа должна выводить текст на экран.
 * 2. Класс Whale должен наследоваться от класса Cow.
 * 3. Класс Whale должен переопределять метод getName().
 * 4. Метод main() должен вызывать метод getName() у объекта cow.
 * 5. Переопределить метод getName в классе Whale(Кит), чтобы программа выводила на экран: "Я не корова, Я - кит."
 * 6. Метод main() должен выводить на экран результат вызова метода getName().
 */

public class Task01 {
    public static void main(String[] args) {
        Cow cow = new Whale();

        System.out.println(cow.getName());
    }

    public static class Cow {
        public String getName() {
            return "Я - корова";
        }
    }

    public static class Whale extends Cow {

    }
}
