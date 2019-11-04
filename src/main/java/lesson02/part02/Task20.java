package lesson02.part02;

import java.util.Arrays;
import java.util.Collections;
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
        Scanner s = new Scanner(System.in);
        Integer[] nums = {s.nextInt(), s.nextInt(), s.nextInt()};
        Arrays.sort(nums, Collections.reverseOrder());

        for(int i = 0; i < 3; ++i){
            System.out.print(nums[i] + " ");
        }
    }
}
