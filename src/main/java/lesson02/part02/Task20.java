package lesson02.part02;

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

import java.io.*;
import java.util.*;


public class Task20 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int c1,c2,c3,buf;
        System.out.print("Введите данные ");
        String cS = bufferedReader.readLine();
        c1 = Integer.parseInt(cS);
        cS = bufferedReader.readLine();
        c2 = Integer.parseInt(cS);
        if(c2>c1) {
            buf=c1;
            c1 = c2;
            c2=buf;
        }
        cS = bufferedReader.readLine();
        c3 = Integer.parseInt(cS);
        if(c3>c2){
            buf=c3;
            c3 = c2;
            c2=buf;
        }
        if(c2>c1) {
            buf=c1;
            c1 = c2;
            c2=buf;
        }
            System.out.print(c1+" "+c2+" "+c3);

    }
}
