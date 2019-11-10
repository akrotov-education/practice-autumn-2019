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
    Map<String, Integer> map = new HashMap<>();
    map.put("1", 34);
    map.put("2", 2453);
    map.put("3", 2435);
    map.put("4", 23454);
    map.put("5", 2345);
    map.put("6", 2345);
    map.put("7", 2354);
    map.put("8", 33);
    map.put("9", 50);
    map.put("10", 3451);

    return map;
  }

  public static void removeItemFromMap(Map<String, Integer> map) {
    Iterator<Map.Entry<String, Integer>> i= map.entrySet().iterator();
    while (i.hasNext()) {
      Integer n = i.next().getValue();
      if (n < 500)
        i.remove();
    }
  }

  public static void main(String[] args) {

  }
}
