package lesson02.part02;

/**
 * Допишите код метода setName, чтобы с его помощью установить значение private String fullName равное значению локальной переменной String fullName.
 * <p>
 * <p>
 * Требования:
 * 1.	Класс Cat должен содержать только одну переменную fullName.
 * 2.	Переменная fullName должна иметь модификатор доступа private и тип String.
 * 3.	Класс Cat должен содержать только два метода setName и main.
 * 4.	Метод setName должен иметь локальную переменную fullName.
 * 5.	Метод setName класса Cat должен устанавливать значение глобальной переменной private String fullName равным локальной переменной fullName.
 */

public class Task06 {

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        //cat1.setName("cat", "catinski");
    }

    public static class Cat {
        private String fullName;

        public void setName(String firstName, String lastName) {
            String fullName = firstName + " " + lastName;
            //System.out.println(fullName);
        }
    }
}
