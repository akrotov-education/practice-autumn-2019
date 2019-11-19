package lesson02.part02;

/**
 * Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны».
 * Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
 * Если имена и длины имен разные - ничего не выводить.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать две строки c клавиатуры.
 * 2.	Программа должна содержать System.out.println() или System.out.print()
 * 3.	Если имена одинаковые вывести сообщение "Имена идентичны"
 * 4.	Если имена разные, но их длины равны , вывести сообщение "Длины имен равны"
 * 5.	Если имена и длины имен разные - ничего не выводить.
 */

import java.io.*;
import java.util.*;


public class Task21 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String n1,n2;
        System.out.print("Введите имена \n");
        n1 = bufferedReader.readLine();
        n2 = bufferedReader.readLine();
        if(n1.equals(n2))
            System.out.print("Имена идентичны");

        else if(n1.length()==n2.length())
            System.out.print("Длины имен равны");
    }
}
