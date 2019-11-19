package lesson04.part01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * 1. Создать массив на 10 строк.
 * 2. Создать массив на 10 чисел.
 * 3. Ввести с клавиатуры 10 строк, заполнить ими массив строк.
 * 4. В каждую ячейку массива чисел записать длину строки из массива строк,
 * индекс/номер ячейки которой совпадает с текущим индексом из массива чисел.
 *
 * Вывести содержимое массива чисел на экран, каждое значение выводить с новой строки.
 *
 * Требования:
 * 1.	Программа должна создавать массив на 10 строк.
 * 2.	Программа должна создавать массив на 10 целых чисел.
 * 3.	Программа должна считывать строки для массива с клавиатуры.
 * 4. Программа должна в массив чисел записать длины строк из массива строк,
 * а затем их вывести на экран.
 */

//import java.io.*;
//import java.util.*;
//      String cS = bufferedReader.readLine();
//      c = Integer.parseInt(cS);


public class Task03 {

  public static void main(String[] args) throws Exception {
    //напишите тут ваш код
    String masStr[]= new String[10];
    int masLen[]= new int[10];
    InputStream inputStream = System.in;
    Reader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    for(int i=0;i<10;i++)
    {
      masStr[i] = bufferedReader.readLine();
      masLen[i]=masStr[i].length();
    }
    for(int i=0;i<10;i++)
      System.out.print(masLen[i]+"\n");
  }
}
