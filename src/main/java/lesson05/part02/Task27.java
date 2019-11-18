package lesson05.part02;

/**
 * CanFly, CanRun, CanSwim для классов Duck, Penguin, Toad
 * Есть интерфейсы CanFly(летать), CanSwim(плавать), CanRun(бегать).
 * Добавь эти интерфейсы классам Duck(утка), Penguin(пингвин), Toad(жаба)
 * <p>
 * <p>
 * Требования:
 * 1. Класс Solution должен содержать интерфейс CanFly с методом void fly().
 * 2. Класс Solution должен содержать интерфейс CanSwim с методом void swim().
 * 3. Класс Solution должен содержать интерфейс CanRun с методом void run().
 * 4. Класс Solution должен содержать классы Duck, Penguin, Toad.
 * 5. Объект класса Duck должен уметь летать(поддерживать интерфейс Fly), бегать(поддерживать интерфейс Run) и плавать(поддерживать интерфейс Swim).
 * 6. Объект класса Penguin должен уметь бегать(поддерживать интерфейс Run) и плавать(поддерживать интерфейс Swim).
 * 7. Объект класса Toad должен уметь только плавать(поддерживать интерфейс Swim).
 */

public class Task27 {
    public static void main(String[] args) {

    }

    public interface CanFly {
        void fly();
    }

    public interface CanRun {
        void run();
    }

    public interface CanSwim {
        void swim();
    }

    public class Duck {

    }

    public class Penguin {

    }

    public class Toad {

    }
}
