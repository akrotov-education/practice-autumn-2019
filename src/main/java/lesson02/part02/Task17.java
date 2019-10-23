package lesson02.part02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
 * Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
 * Примеры:
 * а) при вводе чисел
 * 1
 * 2
 * 2
 * получим вывод
 * 2 2
 * <p>
 * б) при вводе чисел
 * 2
 * 2
 * 2
 * получим вывод
 * 2 2 2
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна содержать System.out.println() или System.out.print()
 * 3.	Если два числа равны между собой, необходимо вывести числа на экран.
 * 4.	Если все три числа равны между собой, необходимо вывести все три.
 * 5.	Если нет равных чисел, ничего не выводить.
 */

public class Task17 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            System.out.println("введите число");
            numbers.add(in.nextInt());
        }
        if (numbers.get(0).equals(numbers.get(1)) && numbers.get(0).equals(numbers.get(2))) {
            for (int i = 0; i < 3; i++)
                System.out.print(numbers.get(i) + " ");
            System.exit(0);
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 3; j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    System.out.print(numbers.get(i) + " " + numbers.get(j));
                    System.exit(0);
                }
            }
        }
    }
}