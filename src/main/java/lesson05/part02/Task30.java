package lesson05.part02;

/**
 * Мужчина или женщина?
 * 1. Изменить метод printName так, чтобы он выполнялся для man и woman.
 * 2. Реализация метода printName должна быть одна.
 * <p>
 * <p>
 * Требования:
 * 1. В классе Solution должен быть реализован только один метод printName.
 * 2. Метод printName должен принимать один параметр типа Human.
 * 3. Класс Man должен быть потомком класса Human.
 * 4. Класс Woman должен быть потомком класса Human.
 */

public class Task30 {
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();

        printName(man);
        printName(woman);
    }

    public static void printName(Human Human) {

    }

    public static class Human {

    }

    public static class Man extends Human {

    }

    public static class Woman extends Human {

    }
}