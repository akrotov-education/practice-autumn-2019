package lesson04.part02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Нужно создать два списка - LinkedList и ArrayList.
 *
 * Требования:
 * 1.	Программа не должна выводить текст на экран.
 * 2.	Программа не должна считывать значения с клавиатуры.
 * 3.	Программа должна содержать только три метода.
 * 4.	Метод createArrayList() должен создавать и возвращать список ArrayList.
 * 5.	Метод createLinkedList() должен создавать и возвращать список LinkedList.
 */

public class Task27 {

  public static Object createArrayList() {
    //напишите тут ваш код
    ArrayList<String> listA = new ArrayList<String>();
    return listA;
  }

  public static Object createLinkedList() {
    //напишите тут ваш код
    List<String> listL = new LinkedList<String>();
    return listL;
  }

  public static void main(String[] args) {
    Object listL = createLinkedList();
    Object listA = createArrayList();


  }
}
