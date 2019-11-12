package lesson02.part02;

/**
 * Ввести с клавиатуры четыре числа, и вывести максимальное из них. Если числа равны между собой, необходимо вывести любое.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить число на экран.
 * 3.	Программа должна выводить на экран максимальное из четырёх чисел.
 * 4.	Если максимальных чисел несколько, необходимо вывести любое из них.
 */


import java.io.*;
import java.util.*;

public class Task19 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int c1,c2;
        System.out.print("Введите данные ");
        String cS = bufferedReader.readLine();
        c1 = Integer.parseInt(cS);
        cS = bufferedReader.readLine();
        c2 = Integer.parseInt(cS);
        if(c2>c1)
            c1=c2;
        cS = bufferedReader.readLine();
        c2 = Integer.parseInt(cS);
        if(c2>c1)
            c1=c2;
        cS = bufferedReader.readLine();
        c2 = Integer.parseInt(cS);
        if(c2>c1)
            System.out.print(c2);
        else

            System.out.print(c1);
    }
}
