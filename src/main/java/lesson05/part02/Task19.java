package lesson05.part02;

/**
 * Создаем человека
 * Есть public интерфейсы CanFly(летать), CanRun(бежать/ездить), CanSwim(плавать).
 * Добавь эти интерфейсы классам Human(человек), Duck(утка), Penguin(пингвин), Airplane(самолет).
 * <p>
 * <p>
 * Требования:
 * 1. Класс задачи должен содержать интерфейс CanFly с одним методом fly().
 * 2. Класс задачи должен содержать интерфейс CanRun с одним методом run().
 * 3. Класс задачи должен содержать интерфейс CanSwim с одним методом swim().
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
        public void run() {
        }

        public void swim() {
        }
    }

    public class Duck implements CanFly, CanSwim, CanRun {
        public void fly() {
        }

        public void run() {
        }

        public void swim() {
        }
    }

    public class Penguin implements CanRun, CanSwim {
        public void run() {
        }

        public void swim() {
        }
    }

    public class Airplane implements CanFly, CanRun {
        public void fly() {
        }

        public void run() {
        }
    }
}