package lesson02.part02;

import java.util.*;
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
        List<Double> numbers = new ArrayList<Double>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите число");
            numbers.add(in.nextDouble());
        }
        numbers.sort(Comparator.reverseOrder());
        for (int i = 0; i < 3; i++)
            System.out.print(numbers.get(i) + " ");
    }
}
