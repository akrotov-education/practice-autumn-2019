package lesson02.part02;

/**
 * Вводить с клавиатуры числа.
 * Если пользователь ввел -1, вывести на экран сумму всех введенных чисел и завершить программу.
 * -1 должно учитываться в сумме.
 * <p>
 * Подсказка: один из вариантов решения этой задачи, использовать конструкцию:
 * while (true) {
 * int number = считываем число;
 * if (проверяем, что number -1)
 * break;
 * }
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Если пользователь ввел -1, программа должна вывести сумму всех введенных чисел на экран и завершиться.
 * 3.	Программа должна посчитать сумму введенных чисел и вывести её на экран.
 * 4.	В программе должен использоваться цикл for, while или do-while.
 */

import java.io.*;
import java.util.*;

public class Task42 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int i=0;
        int s=0;

        System.out.print("Введите данные \n");
        while(i!=(-1)){
            String cS = bufferedReader.readLine();
            i=Integer.parseInt(cS);
            s=s+ i;
        }
        s++;
        System.out.print("\n"+s);
    }
}
