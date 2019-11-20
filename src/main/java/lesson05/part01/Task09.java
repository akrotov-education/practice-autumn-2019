package lesson05.part01;

/**
 * Как кошка с собакой
 * Скрыть все внутренние переменные класса Cat и Dog.
 * Также скрыть все методы, кроме тех, с помощью которых эти классы взаимодействуют друг с другом.
 * <p>
 * <p>
 * Требования:
 * 1. Переменные класса Cat должны быть скрыты.
 * 2. Переменные класса Dog должны быть скрыты.
 * 3. Методы класса Cat должы быть скрыты.
 * 4. Методы класса Dog должы быть скрыты.
 * 5. Методы, с помощью которых классы Cat и Dog взаимодействуют друг с другом, должны быть публичными.
 */

public class Task09 {
    public static void main(String[] args) {
        Cat cat = new Cat("Vaska", 5);
        Dog dog = new Dog("Sharik", 4);

        cat.isDogNear(dog);
        dog.isCatNear(cat);
    }
}

class Cat {
    public String name;
    public int speed;

    public Cat(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isDogNear(Dog dog) {
        return this.speed > dog.getSpeed();
    }
}

class Dog {
    public String name;
    public int speed;

    public Dog(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isCatNear(Cat cat) {
        return this.speed > cat.getSpeed();
    }
}



