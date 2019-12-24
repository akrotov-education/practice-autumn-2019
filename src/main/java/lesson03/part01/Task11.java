package lesson03.part01;

/**
 * Создать class Person. У человека должно быть имя String name, возраст int age.
 * Добавь метод initialize(String name, int age), в котором проинициализируй переменные name и age.
 * В методе main создай объект Person, занеси его ссылку в переменную person.
 * Вызови метод initialize с любыми значениями.
 *
 * Требования:
 * 1.	Класс задачи должен содержать класс Person.
 * 2.	У класса Person должна быть переменная name с типом String.
 * 3.	У класса Person должна быть переменная age с типом int.
 * 4.	У класса Person должен быть метод initialize, принимающий в качестве параметра
 * имя, возраст и инициализирующий соответствующие переменные класса.
 * 5.	Необходимо создать объект типа Person и занести его ссылку в переменную person.
 * 6.	Необходимо вызвать метод initialize у созданного объекта и передать в него какие-либо параметры.
 */

public class Task11 {

    public static void main(String[] args) {
        Person person = new Person();
        person.initialize("Barsuk", 10);
    }

    static class Person {
        String name;
        int age;

        public void initialize(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

}