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

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String name = bufferedReader.readLine();
        String str1 = bufferedReader.readLine();
        String str2 = bufferedReader.readLine();

        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);

        System.out.print(name + " получает " + num1 + " через " + num2 + " лет.");
    }
}
