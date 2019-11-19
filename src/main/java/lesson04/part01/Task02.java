package lesson04.part01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * 1. Создать массив на 10 строк.
 * 2. Ввести с клавиатуры 8 строк и сохранить их в массив.
 * 3. Вывести содержимое всего массива (10 элементов) на экран в обратном порядке.
 * Каждый элемент - с новой строки.
 *
 * Требования:
 * 1.	Программа должна создавать массив на 10 строк.
 * 2.	Программа должна считывать 8 строк для массива с клавиатуры.
 * 3.	Программа должна выводить на экран 10 строк, каждую с новой строки.
 * 4.	Программа должна выводить на экран массив (10 элементов) в обратном порядке.
 */


import java.io.*;
import java.util.*;
//throws IOException
//      String cS = bufferedReader.readLine();
//      c = Integer.parseInt(cS);

public class Task02 {

  public static void main(String[] args) throws Exception {
    //напишите тут ваш код
    String masStr[]= new String[10];
    InputStream inputStream = System.in;
    Reader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    for(int i=0;i<8;i++)
    {
      masStr[i] = bufferedReader.readLine();
    }
    for(int i=9;i>=0;i--)
    {
      System.out.print(masStr[i]+" ");
    }
  }
}
