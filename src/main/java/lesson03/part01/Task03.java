package lesson03.part01;

/**
 * Пару задач назад студенты создавали класс Cat.
 * Теперь пришла пора реализовать котов во плоти, разумеется по образу и подобию класса Cat,
 * а точнее - основываясь на нём, как на шаблоне. Их - котов - должно быть трое.
 * Наполните этих троих жизнью, то есть, конкретными данными.
 *
 * Требования:
 * 1.	Программа не должна считывать данные с клавиатуры.
 * 2.	Нужно создать три объекта типа Cat.
 * 3.	Класс Cat нельзя изменять.
 * 4.	Программа не должна выводить данные на экран.
 */

public class Task03 {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik",9,5,67);
        Cat cat2 = new Cat("Kot",11,7,77);
        Cat cat3 = new Cat("Pirojok",13,13,13);
    }
    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }

}