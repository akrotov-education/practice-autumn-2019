package lesson02.part02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Ввести с клавиатуры имя и возраст. Если возраст больше 20 вывести надпись «И 18-ти достаточно».
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать строки c клавиатуры.
 * 2.	Программа должна использовать команду System.out.println() или System.out.print().
 * 3.	Если возраст больше 20 вывести только сообщение "И 18-ти достаточно".
 * 4.	Если возраст меньше либо равно 20 ничего не выводить.
 */

public class Task23 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя: ");
        String a=reader.readLine();
        System.out.println("Введите возраст: ");
        String b=reader.readLine();
        int c=Integer.parseInt(b);
        if(c>20)System.out.println("И 18-ти достаточно");

    }
}
