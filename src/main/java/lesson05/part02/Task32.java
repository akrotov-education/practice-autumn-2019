package lesson05.part02;

/**
 * Нужно добавить в программу новую функциональность
 * Сделать класс Pegasus(пегас) на основе класса Horse(лошадь) и интерфейса CanFly(летать).
 * <p>
 * <p>
 * Требования:
 * 1. Класс Solution должен содержать интерфейс CanFly с методом fly().
 * 2. Класс Solution должен содержать класс Horse с методом run().
 * 3. Класс Solution должен содержать класс Pegasus.
 * 4. Класс Pegasus должен наследоваться от класса Horse.
 * 5. Класс Pegasus должен реализовывать интерфейс CanFly.
 */

public class Task32 {
    public static void main(String[] args) {
        Pegasus horse = new Pegasus();
    }

    public interface CanFly {
        void fly();
    }

    public static class Horse {
        public void run() {

        }
    }

    public static class Pegasus {
    }
}
