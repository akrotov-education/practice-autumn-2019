package lesson05.part02;

/**
 * Интерфейсы к классу Human
 * Добавь как можно больше интерфейсов к классу Human, но чтобы он не стал абстрактным классом.
 * Добавлять методы в класс Human запрещается.
 * <p>
 * <p>
 * Требования:
 * 1. Класс Solution должен содержать интерфейс Worker с методом void workLazy().
 * 2. Класс Solution должен содержать интерфейс Businessman с методом void workHard().
 * 3. Класс Solution должен содержать интерфейс Secretary с методом void workLazy().
 * 4. Класс Solution должен содержать интерфейс Miner с методом void workVeryHard().
 * 5. Класс Solution должен содержать класс Human с методами: void workHard() и void workLazy().
 * 6. Класс Human должен реализовывать три интерфейса.
 */

public class Task28 {
    public static void main(String[] args) {
        Human human = new Human();
        System.out.println(human);
    }

    public interface Worker {
        void workLazy();
    }

    public interface Businessman {
        void workHard();
    }

    public interface Secretary {
        void workLazy();
    }

    public interface Miner {
        void workVeryHard();
    }

    public static class Human {

        public void workHard() {
        }

        public void workLazy() {
        }
    }
}
