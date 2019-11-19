package lesson02.part02;

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


import java.io.*;
import java.util.*;

public class Task17 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int c1,c2,c3;
        System.out.print("Введите данные ");
        String cS = bufferedReader.readLine();
        c1 = Integer.parseInt(cS);
        cS = bufferedReader.readLine();
        c2 = Integer.parseInt(cS);
        cS = bufferedReader.readLine();
        c3 = Integer.parseInt(cS);

        int i=0;
        if(c1==c2)
        {
            System.out.print(c1+ " "+c2);
            i++;
        }
        if(c2==c3 && i==1)
            System.out.print(" " + c3);
        if(i==0 && c2==c3)
            System.out.print(c2+ " "+c3);
        if(c1==c3 && i==0)
            System.out.print(c1+" "+c3);


    }
}