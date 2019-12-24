package lesson03.part01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Сделать класс ConsoleReader, у которого будут 4 статических метода:
 * String readString() - читает с клавиатуры строку
 * int readInt() - читает с клавиатуры число
 * double readDouble() - читает с клавиатуры дробное число
 * boolean readBoolean() - читает с клавиатуры строку "true" или "false" и возвращает
 * соответствующую логическую переменную true или false
 * <p>
 * Внимание: создавайте переменную для чтения данных с консоли (BufferedReader или Scanner)
 * внутри каждого метода.
 * <p>
 * Требования:
 * 1.	Метод readString должен считывать и возвращать строку(тип String).
 * 2.	Метод readInt должен считывать и возвращать число(тип int).
 * 3.	Метод readDouble должен считывать и возвращать дробное число(тип double).
 * 4.	Метод readBoolean должен считывать и возвращать логическую переменную(тип boolean).
 */

public class Task22 {

  public static void main(String[] args) throws Exception {

  }

  public static class ConsoleReader {

    public static String readString() throws Exception {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String string = reader.readLine();
      return string;
    }

    public static int readInt() throws Exception {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      Integer numInt = Integer.parseInt(reader.readLine());
      return numInt;
    }

    public static double readDouble() throws Exception {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      Double numDo = Double.parseDouble(reader.readLine());
      return numDo;
    }

    public static boolean readBoolean() throws Exception {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      Boolean bool = Boolean.parseBoolean(reader.readLine());
      return bool;
    }
  }

}