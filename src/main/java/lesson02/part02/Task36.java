package lesson02.part02;

/**
 * Ввести с клавиатуры два числа m и n.
 * Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
 * Пример: m=2, n=4
 * 8888
 * 8888
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать два числа c клавиатуры.
 * 2.	Программа должна выводить текст на экран.
 * 3.	Программа должна выводить прямоугольник размером m на n из восьмёрок.
 * 4.	В программе должен использоваться цикл for.
 */
import java.util.Scanner;
public class Task36 {
    public static void main(String[] args) throws Exception {
        int m, n;
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();

        for (int i=m; i>0; i--) {
            for (int j=n; j>0; j--) {
                System.out.print(8);
            }
            System.out.print("\n");

    }}
}
