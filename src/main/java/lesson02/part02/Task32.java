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
import java.util.*;
public class Task32 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = in.nextInt();
        int i = 0;
        while(n > i) {
            System.out.println(str);
            i++;
        }
    }
}
