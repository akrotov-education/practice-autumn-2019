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
        //напишите тут ваш код

        Scanner scanner = new Scanner(System.in);

        System.out.println("Name: ?");
        String name = scanner.nextLine();

        System.out.println("Value: ?");
        int value = scanner.nextInt();

        System.out.println("Years: ?");
        int years = scanner.nextInt();

        System.out.println(name + " получает " + value + " через " + years + " лет.");
    }
}
