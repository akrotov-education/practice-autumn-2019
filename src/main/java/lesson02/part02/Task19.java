package lesson02.part02;
import java.util.Scanner;
/**
 * Ввести с клавиатуры четыре числа, и вывести максимальное из них. Если числа равны между собой, необходимо вывести любое.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить число на экран.
 * 3.	Программа должна выводить на экран максимальное из четырёх чисел.
 * 4.	Если максимальных чисел несколько, необходимо вывести любое из них.
 */

public class Task19 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner in = new Scanner(System.in);
        int[] arr = new int[4];
        for(int i = 0; i < 4; i ++)
            arr[i] = in.nextInt();
        int max = arr[0];
        for(int i = 1; i < arr.length; i++)
            if(arr[i] > max)
                max = arr[i];
        System.out.println(max);
    }
}
