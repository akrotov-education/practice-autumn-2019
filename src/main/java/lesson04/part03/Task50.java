package lesson04.part03;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Написать программу, которая будет вводить числа с клавиатуры.
 * Код по чтению чисел с клавиатуры должен быть в методе readData.
 * Код внутри readData обернуть в try..catch.
 * Если пользователь ввёл какой-то текст, вместо ввода числа, то метод должен перехватить исключение
 * и вывести на экран все ранее введенные числа в качестве результата.
 * Числа выводить с новой строки сохраняя порядок ввода.
 *
 * Требования:
 * 1.	Программа должна считывать данные с клавиатуры.
 * 2.	Метод main не изменять.
 * 3.	Метод main не должен кидать исключений.
 * 4. Метод readData должен содержать блок try..catch.
 * 5.	Если пользователь ввел текст, а не число, программа должна вывести все ранее введенные числа.
 */

public class Task50 {
  public static void main(String[] args) {
    readData();
  }

  public static void readData() {
    //напишите тут ваш код
    ArrayList<Integer> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    try {
      for(;;){
        list.add(scanner.nextInt());
      }
    }
    catch (Exception e){
      for(Integer i: list){
        System.out.println(i);
      }
    }
  }
}
