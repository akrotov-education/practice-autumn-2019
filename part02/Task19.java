package lesson05.part02;

/**
 * Создаем человека
 * Есть public интерфейсы CanFly(летать), CanRun(бежать/ездить), CanSwim(плавать).
 * Добавь эти интерфейсы классам Human(человек), Duck(утка), Penguin(пингвин), Airplane(самолет).
 * <p>
 * <p>
 * Требования:
 * 1. Класс Solution должен содержать интерфейс CanFly с одним методом fly().
 * 2. Класс Solution должен содержать интерфейс CanRun с одним методом run().
 * 3. Класс Solution должен содержать интерфейс CanSwim с одним методом swim().
 * 4. Человек должен уметь бегать и плавать.
 * 5. Утка должна уметь летать, плавать и бегать.
 * 6. Пингвин должен уметь плавать и бегать.
 * 7. Самолет должен уметь летать и ездить.
 */

public class Task19 {
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


    public class Human implements CanRun, CanSwim {

        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Duck implements CanFly, CanSwim, CanRun {

        @Override
        public void fly() {

        }

        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Penguin implements CanRun, CanSwim {

        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Airplane implements CanRun, CanFly {

        @Override
        public void fly() {

        }

        @Override
        public void run() {

        }
    }
}
