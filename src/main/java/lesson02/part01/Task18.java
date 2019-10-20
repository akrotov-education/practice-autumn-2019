package lesson02.part01;

/**
 * Ввести с клавиатуры отдельно Имя, число1, число2. Вывести надпись:
 * «Имя» получает «число1» через «число2» лет.
 * Пример: Коля получает 3000 через 5 лет.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна выводить текст.
 * 2.	Программа должна считывать данные с клавиатуры.
 * 3.	Выведенный текст должен содержать введенное имя.
 * 4.	Выведенный текст должен содержать введенное число1.
 * 5.	Выведенный текст должен содержать введенное число2.
 * 6.	Выведенный тест должен полностью соответствовать заданию.
 */

import java.io.*;
import java.util.*;

public class Task18 {
    public static void main(String[] args) throws Exception {
        System.out.print("Введите имя: ");
        BufferedReader name = new BufferedReader(new InputStreamReader(System.in));
        String str1 = name.readLine();
        System.out.print("Введите первое число: ");
        BufferedReader number1 = new BufferedReader(new InputStreamReader(System.in));
        String str2 = number1.readLine();
        System.out.print("Введите второе число: ");
        BufferedReader number2 = new BufferedReader(new InputStreamReader(System.in));
        String str3 = number2.readLine();
        System.out.println(str1 + " получает " + str2 + " через " + str3 + " лет");
    }
}
