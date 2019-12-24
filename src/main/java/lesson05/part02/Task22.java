package lesson05.part02;

/**
 * Больше не Пушистик
 * Переопредели метод setName в классе Cat так, чтобы программа выдавала на экран надпись
 * <p>
 * "Я - кот"
 * <p>
 * <p>
 * Требования:
 * 1. Класс задачи должен содержать класс Pet.
 * 2. Класс задачи должен содержать класс Cat.
 * 3. Класс Cat должен наследоваться от класса Pet.
 * 4. Класс Pet должен содержать два метода getName() и setName().
 * 5. Класс Cat должен переопределять метод setName().
 * 6. Программа должна выводить на экран результат метода getName() объекта pet.
 */

public class Task22 {
    public static void main(String[] args) {
        Pet pet = new Cat();
        pet.setName("Я - кот");

        System.out.println(pet.getName());
    }

    public static class Pet {
        protected String name;

        public Pet() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class Cat extends Pet {

    }
}