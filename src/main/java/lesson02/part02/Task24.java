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
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String num11,num22,num33;
    num11 = reader.readLine();
    num22 = reader.readLine();
    num33 = reader.readLine();
    int num1 = Integer.parseInt(num11);
    int num2 = Integer.parseInt(num22);
    int num3 = Integer.parseInt(num33);
    if(num1==num2){
        System.out.println(3);
    }
    if(num2==num3){
        System.out.println(1);
    }
    if(num1==num3){
        System.out.println(2);
    }
    }
}
