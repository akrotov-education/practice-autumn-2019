package lesson02.part02;
import java.util.Scanner;
/**
 * Ввести с клавиатуры три числа, и вывести их в порядке убывания. Выведенные числа должны быть разделены пробелом.
 *
 *
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить числа на экран.
 * 3.	Программа должна выводить три числа разделенных пробелами.
 * 4.	Программа должна выводить числа в порядке убывания.
*/

public class Task20 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner in = new Scanner(System.in);
        int[] n = new int[3];
        for(int i = 0; i < n.length; i++)
            n[i] = in.nextInt();
        for(int i = 0; i < n.length; i++)
            for(int j = 0; j < n.length - i - 1; j++)
                if(n[j] < n[j + 1]) {
                    int a = n[j];
                    n[j] = n[j + 1];
                    n[j + 1] = a;
                }
        System.out.println(n[0] + " " + n[1] + " " + n[2]);
    }
}
