package lesson02.part02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

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
        System.out.print("Введите имя: ");
        BufferedReader str0 = new BufferedReader(new InputStreamReader(System.in));
        String name = str0.readLine();
        System.out.println("Введите три числа: ");
        Scanner str = new Scanner(System.in);
        int d = str.nextInt();
        int m = str.nextInt();
        int y = str.nextInt();
        System.out.println("Меня зовут " + name + ". \nЯ родился " + d + "." + m + "." + y);
    }
}
