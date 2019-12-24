package lesson02.part02;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название «понедельник», «вторник», «среда»,
 * «четверг», «пятница», «суббота», «воскресенье», если введен номер больше 7 или меньше 1 – вывести «такого дня недели
 * не существует». Пример для номера 5: пятница Пример для номера 10: такого дня недели не существует
 * <p>
 * <p>
 * Требования: 1.	Программа должна считывать число c клавиатуры. 2.	Программа должна выводить текст на экран. 3.	Если
 * введено число от 1 до 7, необходимо вывести день недели. 4.	Если введено число не входящее в интервал от 1 до 7, то
 * вывести уведомление что такого дня недели не существует.
 */

public class Task13 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println(" ");
        String number = bufferedReader.readLine();
        int a = Integer.parseInt(number);
        if (a == 1) {
            System.out.println("Понедельник");
        }
        else if (a == 2) {
            System.out.println("Вторник");
        }
        else if (a == 3) {
            System.out.println("Среда");
        }
        else if (a == 4) {
            System.out.println("Четверг");
        }
        else if (a == 5) {
            System.out.println("Пятница");
        }
        else if (a == 6) {
            System.out.println("Суббота");
        }
        else if (a == 7) {
            System.out.println("Воскресенье");
        } else {
            System.out.println("Такого дня недели не существует");
        }
    }
}