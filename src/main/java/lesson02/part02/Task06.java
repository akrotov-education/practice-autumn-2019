package lesson02.part02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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

    public static void main(String[] args) throws Exception{
        System.out.print("Введите имя и фамилию: ");
        BufferedReader firstname = new BufferedReader(new InputStreamReader(System.in));
        String str1 = firstname.readLine();
        BufferedReader lastname = new BufferedReader(new InputStreamReader(System.in));
        String str2 = lastname.readLine();
        Cat cat = new Cat();
        cat.setName(str1,str2);
        System.out.println("Полное имя котика: " + cat.fullName);
    }

    public static class Cat {

        private String fullName;

        public void setName(String firstName, String lastName) {
            this.fullName = firstName + " " + lastName;
        }
    }
}
