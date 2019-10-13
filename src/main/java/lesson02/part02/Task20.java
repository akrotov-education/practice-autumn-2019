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
	   	int mas[] = new int[3];
	   	for (int i = 0; i < mas.length; i++) {
			mas[i] = in.nextInt();
		}
	 	for (int i = 1; i < mas.length; i++) {
			if(mas[i] < mas[i-1]) {
				int temp = mas[i-1];
				mas[i-1] = mas[i];
				mas[i] = temp;
			}
		}
	 	for (int i : mas) {
			System.out.println(i + " ");
		}
	 	in.close();
    }
}
