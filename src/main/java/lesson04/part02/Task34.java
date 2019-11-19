package lesson04.part02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: "фамилия" - "зарплата".
 * Удалить из словаря всех людей, у которых зарплата ниже 500.
 * <p>
 * Требования:
 * 1.	Программа не должна выводить текст на экран.
 * 2.	Программа не должна считывать значения с клавиатуры.
 * 3.	Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, Integer состоящих из 10 записей по принципу «фамилия» - «зарплата».
 * 4.	Метод removeItemFromMap() должен удалять из словаря всех людей, у которых зарплата ниже 500.
 */

public class Task34 {

  public static Map<String, Integer> createMap() {
    //напишите тут ваш код
    Map<String,Integer> mas = new HashMap<>();
    mas.put("Kolya",754);
    mas.put("Olya",430);
    mas.put("Molya",624);
    mas.put("Dalya",104);
    mas.put("Zaya",390);
    mas.put("Vasya",784);
    mas.put("Katya",930);
    mas.put("Dashya",538);
    mas.put("Zolya",295);
    mas.put("Fedya",855);
    return mas;
  }

  public static void removeItemFromMap(Map<String, Integer> mas) {
    //напишите тут ваш код
    Iterator<Map.Entry<String, Integer>> iterKey = mas.entrySet().iterator();

    while (iterKey.hasNext())
    {
      if(iterKey.next().getValue()<500)
        iterKey.remove();
    }
  }

  public static void main(String[] args) {
    Map<String,Integer> mas=createMap();
    removeItemFromMap(mas);
    Iterator<Map.Entry<String, Integer>> iterKey = mas.entrySet().iterator();
    Iterator<Map.Entry<String, Integer>> iterVal = mas.entrySet().iterator();

    while (iterKey.hasNext())
    {
      System.out.println(iterKey.next().getKey() + " - " + iterVal.next().getValue());
    }

  }
}
