package lesson02.part02;

/**
 * Помогите коту обрести имя с помощью метода setName.
 * <p>
 * <p>
 * Требования:
 * 1.	Класс Cat должен содержать только одну переменную name.
 * 2.	Переменная name должна иметь модификатор доступа private и тип String.
 * 3.	Класс Cat должен содержать только два метода setName и main.
 * 4.	Метод setName класса Cat должен устанавливать значение переменной private String name равным переданному параметру String name.
 */
public class Task03 {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Жужик");
        System.out.println(cat.name);
    }

    public static class Cat {
        private String name = "безымянный кот";

        public void setName(String name) {
            //напишите тут ваш код

        }
    }
}
