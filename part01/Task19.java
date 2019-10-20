package lesson02.part01;

/**
 * Ввести с клавиатуры имя и вывести надпись:
 * name зарабатывает $5,000. Ха-ха-ха!
 * Пример: Тимур зарабатывает $5,000. Ха-ха-ха!
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна выводить текст.
 * 2.	Программа должна считывать данные с клавиатуры.
 * 3.	Выведенный текст должен содержать введенное имя.
 * 4.	Выведенный текст должен полностью соответствовать заданию.
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Task19 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String name = bufferedReader.readLine();

        System.out.print(name + " зарабатывает $5,000 каждый день. Для этого он каждый день...");
    }
}
