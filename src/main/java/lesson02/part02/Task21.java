package lesson02.part02;

/**
 * Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны». Если имена разные, но их
 * длины равны – вывести сообщение – «Длины имен равны». Если имена и длины имен разные - ничего не выводить.
 * <p>
 * <p>
 * Требования: 1.	Программа должна считывать две строки c клавиатуры. 2.	Программа должна содержать System.out.println()
 * или System.out.print() 3.	Если имена одинаковые вывести сообщение "Имена идентичны" 4.	Если имена разные, но их длины
 * равны , вывести сообщение "Длины имен равны" 5.	Если имена и длины имен разные - ничего не выводить.
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Task21 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String name1 = bufferedReader.readLine();
        String name2 = bufferedReader.readLine();
        if (name1.equals(name2)) {
            System.out.println("Имена идентичны");
        }
        else if (name1.length() == name2.length()) {
            System.out.println("Длины имен равны");
        }

    }
}