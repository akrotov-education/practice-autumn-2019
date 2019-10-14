package lesson02.part02;

/**
 * Ввести с клавиатуры два числа m и n.
 * Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
 * Пример: m=2, n=4
 * 8888
 * 8888
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать два числа c клавиатуры.
 * 2.	Программа должна выводить текст на экран.
 * 3.	Программа должна выводить прямоугольник размером m на n из восьмёрок.
 * 4.	В программе должен использоваться цикл for.
 */

import java.io.*;
import java.util.*;

public class Task36 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int c1, c2;
        System.out.print("Введите данные \n");
        String cS = bufferedReader.readLine();
        c1 = Integer.parseInt(cS);
        cS = bufferedReader.readLine();
        c2 = Integer.parseInt(cS);
        for(int i=0;i<c1;i++) {
            for (int j = 0; j < c2; j++)
                System.out.print("8");
            System.out.print("\n");
        }
    }
}
