package lesson02.part02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Ввести с клавиатуры строку name.
 * Ввести с клавиатуры дату рождения (три числа): y, m, d.
 * Вывести на экран текст:
 * «Меня зовут name.
 * Я родился d.m.y»
 * <p>
 * Пример вывода:
 * Меня зовут Вася.
 * Я родился 15.2.1988
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать строки c клавиатуры.
 * 2.	Программа должна выводить строки на экран.
 * 3.	Программа должна выводить текст, шаблон которого указан в задании.
 * 4.	Каждое предложение вывести с новой строки.
 */

public class Task43 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя ");
        String name = reader.readLine();
        System.out.println("Введите день");
        int d = Integer.parseInt(reader.readLine());
        System.out.println("Введите месяц");
        int m = Integer.parseInt(reader.readLine());
        System.out.println("Введите год");
        int y = Integer.parseInt(reader.readLine());
        System.out.println("Меня зовут "+ name);
        System.out.println("Я родился " + d + "." + m + "." + y);

    }
}
