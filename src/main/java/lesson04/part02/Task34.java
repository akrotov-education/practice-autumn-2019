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
    Map<String, Integer> map =  new HashMap();
    map.put("Гейтсey", 300);
    map.put("Пупкинc",400);
    map.put("Пупкин",499);
    map.put("Бойко",500);
    map.put("Гейтсw", 900);
    map.put("Гей", 5000);
    map.put("Гейтsy", 1000);
    map.put("Беляков",158);
    map.put("Гейтth", 200);
    map.put("Гейтсdd", 999);
    return map;
  }
  public static void removeItemFromMap(Map<String, Integer> map) {

    Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()){
      Map.Entry<String, Integer> pair = iterator.next();
      String key = pair.getKey();
      int value = pair.getValue();
      if (value < 500)
        iterator.remove();
    }
  }
  public static void main(String[] args) {
  }
}
