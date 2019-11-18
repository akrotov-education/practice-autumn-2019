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
import java.util.Scanner;
public class Task19 {
    public static void main(String[] args) throws Exception {
        String name;
        Scanner in = new Scanner(System.in);
        name=in.next();
        System.out.printf("%s зарабатывает $5,000. Ха-ха-ха!", name);


    }
}
