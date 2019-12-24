package lesson05.part02;

/**
 * Есть, летать и двигаться
 * Есть public интерфейсы CanFly(летать), CanMove(передвигаться), CanEat(есть).
 * Добавь эти интерфейсы классам Dog(собака), Car(автомобиль), Duck(утка), Airplane(самолет).
 * <p>
 * <p>
 * Требования:
 * 1. Класс задачи должен содержать интерфейс CanFly с одним методом fly().
 * 2. Класс задачи должен содержать интерфейс CanMove с одним методом move().
 * 3. Класс задачи должен содержать интерфейс CanEat с одним методом eat().
 * 4. Собака должна уметь передвигаться и есть.
 * 5. Автомобиль должен уметь передвигаться.
 * 6. Самолет должен уметь передвигаться и летать.
 * 7. Утка должна уметь передвигаться, летать и есть.
 */

public class Task18 {
    public static void main(String[] args) {

    }

    public interface CanFly {
        void fly();
    }

    public interface CanMove {
        void move();
    }

    public interface CanEat {
        void eat();
    }

    public class Dog implements CanMove, CanEat {
        public void move() {
        }

        public void eat() {
        }
    }

    public class Duck implements CanMove, CanEat, CanFly {
        public void fly() {
        }

        public void move() {
        }

        public void eat() {
        }
    }

    public class Car implements CanMove {
        public void move() {
        }
    }

    public class Airplane implements CanMove, CanFly {
        public void fly() {
        }

        public void move() {
        }
    }
}