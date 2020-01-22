package lesson05.part01;

/**
 * Неприступный кот
 * Скрыть все внутренние переменные класса Cat, а также методы, позволяющие менять внутреннее состояние объектов класса Cat.
 * <p>
 * <p>
 * Требования:
 * 1. Переменная name класса Cat должна быть скрыта.
 * 2. Переменная age класса Cat должна быть скрыта.
 * 3. Переменная weight класса Cat должна быть скрыта.
 * 4. В Cat должны быть private и public методы.
 */

public class Task08 {
    public static void main(String[] args) {
    }

    public class Cat {
        private String name;
        private int age;
        private int weight;

        public Cat(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        private void setAge(int age) {
            this.age = age;
        }
    }
}
