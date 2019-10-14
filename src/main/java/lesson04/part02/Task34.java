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
    map.put("Попов", 1);
    map.put("Лыков", 3000);
    map.put("Собянин", 9);
    map.put("Медведев", 5444);
    map.put("Путин", 10000);
    map.put("Жириновский", 1);
    map.put("Буянов", 744);
    map.put("Городничев", 2);
    map.put("Шишкин", 0);
    map.put("Золотов", 1);

    return map;
  }

  public static void removeItemFromMap(Map<String, Integer> map) {
    Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

    while (iterator.hasNext()) {
      Integer n = iterator.next().getValue();

      if (n < 500) {
        iterator.remove();
      }
    }
  }

  public static void main(String[] args) {

  }
}
