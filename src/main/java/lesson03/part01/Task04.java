package lesson03.part01;

/**
 * Создать три кота используя класс Cat.
 * Провести три боя попарно между котами.
 * Класс Cat создавать не надо. Для боя использовать метод boolean fight(Cat anotherCat).
 * Результат каждого боя вывести на экран c новой строки.
 *
 * Требования:
 * 1.	Программа не должна считывать данные с клавиатуры.
 * 2.	Нужно создать три объекта типа Cat.
 * 3.	Нужно провести три боя.
 * 4.	Программа должна вывести результат каждого боя с новой строки.
 */

public class Task04 {

    public static void main(String[] args) {
        Cat Barsuk = new Cat("Barsuk",9,10,100);
        Cat Vasya = new Cat("Vasya",5,8,70);
        Cat Prosha = new Cat("Prosha", 2,6,75);
        System.out.println(Barsuk.fight(Vasya));
        System.out.println(Barsuk.fight(Prosha));
        System.out.println(Vasya.fight(Prosha));
    }

    public static class Cat {
        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int ageAdvantage = this.age > anotherCat.age ? 1 : 0;
            int weightAdvantage = this.weight > anotherCat.weight ? 1 : 0;
            int strengthAdvantage = this.strength > anotherCat.strength ? 1 : 0;

            int score = ageAdvantage + weightAdvantage + strengthAdvantage;
            return score > 2; // return score > 2 ? true : false;
        }
    }

}