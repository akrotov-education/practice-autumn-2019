package lesson05.part02;

/**
 * Корова — тоже животное
 * Унаследуй класс Cow от Animal.
 * Реализуй все недостающие методы в классе Cow.
 * <p>
 * <p>
 * Требования:
 * 1. Класс Animal должен быть абстрактным.
 * 2. Класс Cow не должен быть абстрактным.
 * 3. Класс Cow должен наследоваться от класса Animal.
 * 4. Класс Cow должен реализовать абстрактный метод из класса Animal.
 * 5. Метод getName() класса Cow должен возвращать любое имя коровы.
 */

public class Task14 {
    public static void main(String[] args) {

    }

    public static abstract class Animal {
        public abstract String getName();
    }

    public static class Cow {
    }

}
