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
    Map<String, Integer> map = new HashMap<>();
    map.put("Грибов", 560);
    map.put("Андреев", 390);
    map.put("Алиров", 900);
    map.put("Ванева", 500);
    map.put("Уков", 250);
    map.put("Жукова", 620);
    map.put("Витоев", 280);
    map.put("Каин", 440);
    map.put("Кязев", 990);
    map.put("Ивева", 1000);
    return map;
  }

  public static void removeItemFromMap(Map<String, Integer> map) {
    //напишите тут ваш код
    Iterator<String> it = map.keySet().iterator();
    while (it.hasNext()) {
      String key = it.next();
      if (map.get(key) < 500) {
        it.remove();
      }
    }
  }

  public static void main(String[] args) {

  }
}
