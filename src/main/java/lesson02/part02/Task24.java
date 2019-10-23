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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(Integer.parseInt(reader.readLine()));
        }
        if (!numbers.get(1).equals(numbers.get(0)) && !numbers.get(1).equals(numbers.get(2))) {
            if (numbers.get(0).equals(numbers.get(2))) System.out.println(2);
        }
        if (numbers.get(1).equals(numbers.get(0)) && !numbers.get(1).equals(numbers.get(2)))
            System.out.println(3);
        if (numbers.get(1).equals(numbers.get(2)) && !numbers.get(0).equals(numbers.get(1)))
            System.out.println(1);
    }
}
