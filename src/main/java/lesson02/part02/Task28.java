package lesson02.part02;

/**
 * Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел среди этих трех.
 * Примеры:
 * а) при вводе чисел
 * -4
 * 6
 * 6
 * получим вывод
 * 2
 * <p>
 * б) при вводе чисел
 * -6
 * -6
 * -3
 * получим вывод
 * 0
 * <p>
 * в) при вводе чисел
 * 0
 * 1
 * 2
 * получим вывод
 * 2
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить число на экран.
 * 3.	Программа должна выводить количество положительных чисел в исходном наборе.
 * 4.	Если положительных чисел нет, программа должна вывести "0".
 * 5.	Учти, что "0" не относится ни к положительным, ни к отрицательным числам.
 */

import java.io.*;
import java.util.*;

public class Task28 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int c1, c2, c3;
        System.out.print("Введите данные \n");
        String cS = bufferedReader.readLine();
        c1 = Integer.parseInt(cS);
        cS = bufferedReader.readLine();
        c2 = Integer.parseInt(cS);
        cS = bufferedReader.readLine();
        c3 = Integer.parseInt(cS);

        int i=0;
        if(c1>0)
            i++;
        if(c2>0)
            i++;
        if(c3>0)
            i++;

        System.out.print(i);
    }
}
