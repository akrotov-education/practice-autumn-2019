package lesson02.part02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Ввести с клавиатуры имя и используя цикл for 10 раз вывести: <имя> любит меня.
 * <p>
 * Пример вывода на экран для имени Света:
 * Света любит меня.
 * Света любит меня.
 * Света любит меня.
 * Света любит меня.
 * Света любит меня.
 * Света любит меня.
 * Света любит меня.
 * Света любит меня.
 * Света любит меня.
 * Света любит меня.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать имя c клавиатуры.
 * 2.	Программа должна выводить текст на экран.
 * 3.	Программа должна выводить 10 раз текст указанный в задании.
 * 4.	В программе должен использоваться цикл for.
 */

public class Task39 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String m=reader.readLine();
        for (int j=1;j<=10;j++)
        {

            System.out.println(m+" любит меня.");
        }


    }
}
