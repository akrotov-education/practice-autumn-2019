package lesson02.part02;

/**
 * Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
 * Вывести на экран порядковый номер числа, отличного от остальных.
 * Пример для чисел 4 6 6:
 * 1
 * Пример для чисел 6 6 3:
 * 3
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна использовать команды System.out.println() или System.out.print().
 * 3.	Программа должна выводить на экран порядковый номер числа, отличного от остальных.
 * 4.	Если все числа разные, ничего не выводить.
 */

import java.io.*;
import java.util.*;

public class Task24 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
	   	Scanner in = new Scanner(System.in);
	   	int mas[] = new int[3];
	   	int dif = 0;
	   	for (int i = 0; i < mas.length; i++) {
			mas[i] = in.nextInt();
		}
	 	for (int i = 1; i < mas.length; i++) {
			if(mas[0] != mas[i]) {
				if(dif == 0)
					dif = i+1;
				else {
					dif = 1;
					break;
				}
			}
	 	}
		System.out.println(dif);
	 	in.close();   
    }
}
