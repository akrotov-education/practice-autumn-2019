package lesson02.part02;

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


import java.io.*;
import java.util.*;

public class Task43 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.print("Введите имя \n");
        String nam = bufferedReader.readLine();
        System.out.print("Введите год \n");
        String y = bufferedReader.readLine();
        System.out.print("Введите месяц \n");
        String m = bufferedReader.readLine();
        System.out.print("Введите день \n");
        String d = bufferedReader.readLine();

        System.out.print("Меня зовут " +nam+ ".\nЯ родился "+y+"."+m+"."+d);

    }
}
