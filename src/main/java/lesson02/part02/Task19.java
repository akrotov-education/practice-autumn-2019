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
	 	int a = in.nextInt();
	 	int b = in.nextInt();
	 	int c = in.nextInt();
	 	int d = in.nextInt();
	 	a = Math.max(Math.min(a, b), Math.min(c, d));
		System.out.println(a);
	 	in.close();
    }
}
