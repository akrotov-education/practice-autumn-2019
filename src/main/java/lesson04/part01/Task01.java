package lesson04.part01;

import java.io.*;

/**
 * 1. В методе initializeArray():
 * 1.1. Создайте массив на 20 чисел
 * 1.2. Считайте с консоли 20 чисел и заполните ими массив
 * 2. Метод max(int[] array) должен находить максимальное число из элементов массива
 * <p>
 * Требования:
 * 1.	Метод initializeArray должен создавать массив из 20 целых чисел.
 * 2.	Метод initializeArray должен считать 20 чисел и вернуть их в виде массива.
 * 3.	Метод max должен возвращать максимальный элемент из переданного массива.
 * 4.	Метод main изменять нельзя.
 */

import java.io.*;
import java.util.*;

public class Task01 {

  public static void main(String[] args) throws Exception {
    int[] array = initializeArray();
    int max = max(array);
    System.out.println(max);
  }

  public static int[] initializeArray() throws IOException {
    // создай и заполни массив
    InputStream inputStream = System.in;
    Reader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    int[] mas= new int[20];
    int c;

    System.out.print("Введите данные \n");
    for(int i=0;i<20;i++) {
      String cS = bufferedReader.readLine();
      c = Integer.parseInt(cS);
      mas[i] =c;
    }
    return mas;
  }

  public static int max(int[] mas) {
    // найди максимальное значение
    int max=mas[0];
    for(int i=1;i<20;i++)
      if(mas[i]>max)
        max=mas[i];
    return max;
  }
}
