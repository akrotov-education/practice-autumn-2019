package lesson02.part02;

/**
 * Ввести с клавиатуры строку и число N больше 0.
 * Вывести на экран строку N раз используя цикл while. Каждое значение с новой строки.
 * Пример ввода:
 * абв
 * 2
 * Пример вывода:
 * абв
 * абв
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать текст c клавиатуры.
 * 2.	Программа должна выводить текст на экран.
 * 3.	Каждое значение должно быть выведено с новой строки.
 * 4.	Программа должна выводить на экран строку N раз.
 * 5.	В программе должен использоваться цикл while.
 */
import java.util.Scanner;
public class Task32 {
    public static void main(String[] args) throws Exception {
        int n;
        String a;
        Scanner in = new Scanner(System.in);
        a = in.next();
        n = in.nextInt();

        while (n > 0) {
            System.out.println(a);
            n--;

        }
    }
}
