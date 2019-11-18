package lesson05.part02;

/**
 * Все мы немного кошки…
 * Переопредели метод getName в классе Cat так, чтобы программа выдавала на экран надпись "Я - кот".
 * <p>
 * <p>
 * Требования:
 * 1. Класс Solution должен содержать класс Pet.
 * 2. Класс Solution должен содержать класс Cat.
 * 3. Класс Cat должен наследоваться от класса Pet.
 * 4. Класс Pet должен содержать один метод getName().
 * 5. Класс Cat должен переопределять метод getName().
 * 6. Программа должна выводить на экран результат метода getName() объекта pet.
 */

public class Task21 {
    public static void main(String[] args) {
        Pet pet = new Cat();

        System.out.println(pet.getName());
    }

    public static class Pet {
        public String getName() {
            return "Я - пушистик";
        }
    }

    public static class Cat extends Pet {

    }
}
