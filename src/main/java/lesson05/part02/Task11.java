package lesson05.part02;

/**
 * Абстрактный класс Pet
 * Сделать класс Pet абстрактным.
 * <p>
 * <p>
 * Требования:
 * 1. Программа не должна выводить текст на экран.
 * 2. Класс Pet должен быть статическим.
 * 3. Класс Pet должен быть абстрактным.
 * 4. Класс Pet должен иметь один метод getName().
 */

public class Task11 {
    public static void main(String[] args) {

    }

    public static class Pet {
        public String getName() {
            return "Я - котенок";
        }
    }

}
