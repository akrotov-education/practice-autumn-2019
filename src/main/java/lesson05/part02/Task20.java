package lesson05.part02;

/**
 * Класс Human и интерфейсы CanRun, CanSwim
 * Напиши public класс Human(человек) и public интерфейсы CanRun(бежать/ездить), CanSwim(плавать).
 * Добавь в каждый интерфейс по oдному методу.
 * Добавь эти интерфейсы классу Human, но не реализуй методы.
 * Объяви класс Human абстрактным.
 * <p>
 * <p>
 * Требования:
 * 1. Класс задачи должен содержать интерфейс CanRun с одним методом.
 * 2. Класс задачи должен содержать интерфейс CanSwim с одним методом.
 * 3. Класс задачи должен содержать класс Human.
 * 4. Класс Human должен реализовывать интерфейсы CanRun и CanSwim.
 * 5. Класс Human должен быть абстрактным.
 * 6. Класс Human не должен иметь методов.
 */

public class Task20 {
    public static void main(String[] args) {

    }

    public interface CanRun {
        void run();
    }

    public interface CanSwim {
        void swim();
    }

    public abstract class Human implements CanRun, CanSwim {
    }
}