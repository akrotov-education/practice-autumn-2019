package lesson02.part02;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Ввести с клавиатуры два целых числа, и вывести на экран минимальное из них. Если два числа равны между собой, необходимо вывести любое.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить число на экран.
 * 3.	Программа должна выводить на экран минимальное из двух целых чисел.
 * 4.	Если два числа равны между собой, необходимо вывести любое.
 */

public class Task18 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите первое число");
        String a = reader.readLine();
        int A = Integer.parseInt(a);

        System.out.println("Введите второе число");
        String b = reader.readLine();
        int B = Integer.parseInt(b);

        if (A>B) {
            System.out.println(B);
        }
        else if (A<B) {
            System.out.println(A);
        }
        else if (A==B) {
            System.out.println(A);
        }

    }
}