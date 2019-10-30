package lesson04.part01;

import java.util.ArrayList;

/**
 * 1. Создай список из слов "мама", "мыла", "раму".
 * 2. После каждого слова вставь в список строку, содержащую слово "именно".
 * 3. Вывести результат на экран, каждый элемент списка с новой строки.
 * <p>
 * Требования:
 * 1.	Программа не должна считывать данные с клавиатуры.
 * 2.	Объяви переменную типа список строк и сразу проинициализируй ee.
 * 3.	Добавь в список слова: «мама», «мыла», «раму».
 * 4.	После каждого слова добавь в список строку, содержащую слово «именно».
 * 5.	Выведи элементы списка на экран, каждый с новой строки.
 */

public class Task12 {

  public static void main(String[] args) {
    //напишите тут ваш код
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("мама");
    arrayList.add("мыла");
    arrayList.add("раму");

    ArrayList<String> temp = new ArrayList<>();
    temp.addAll(arrayList);
    for (String str : arrayList) {
      temp.add(temp.indexOf(str) + 1,"Именно");
    }
    for (String str : temp) {
      System.out.println(str);
    }
  }
}

