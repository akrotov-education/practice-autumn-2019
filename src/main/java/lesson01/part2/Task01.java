package lesson01.part2;

public class Task01 {

    /**
     * В классе Person объяви следующие переменные: name типа String, age типа int, weight типа int, money типа int.
     * В методе main создай объект Person, занеси его ссылку в переменную person.
     *
     * Подсказка: для создания объекта Person и занесения его ссылки в переменную person используй конструкцию:
     * ТипПеременной имяПеременной = new ТипСоздаваемогоОбъекта();
     *
     *
     * Требования:
     * 1. В классе Person объяви переменную name типа String.
     * 2. В классе Person объяви переменную age типа int.
     * 3. В классе Person объяви переменную weight типа int.
     * 4. В классе Person объяви переменную money типа int.
     * 5. В методе main создай объект Person и сразу присвой ссылку на него переменной person.
     * 6. Должно быть объявлено 5 переменных.
     */

    public static void main(String[] args) {
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();
		Person person4 = new Person();
		Person person5 = new Person();
    }

    public static class Person {
		String name;
        int age;
        int weight;
        int money;
    }
}
