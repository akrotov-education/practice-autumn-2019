package lesson04.part01;

import java.util.Scanner;

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

public class Task02 {

  public static void main(String[] args) throws Exception {
    //напишите тут ваш код
    String[] str = new String[10];
    Scanner scanner = new Scanner(System.in);
    for(int i = 0; i < 8; ++i){
      str[i] = scanner.nextLine();
    }
    str[8] = "Hello World";
    str[9] = "Bye World";
    for(int i = str.length-1;i>=0;--i){
      System.out.println(str[i]);
    }
  }
}
