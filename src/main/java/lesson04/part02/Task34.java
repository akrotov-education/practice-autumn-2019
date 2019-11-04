package lesson04.part02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
    map.put("Коромыслов", 499);
    map.put("Батурин", 725);
    map.put("Великова", 290);
    map.put("Лопунов", 920);
    map.put("Смотрин", 520);
    map.put("Вашкевич", 460);
    map.put("Нушенко", 660);
    map.put("Вазукова", 730);
    map.put("Киряченко", 370);
    map.put("Крупиньян", 580);
    return map;
  }

  public static void removeItemFromMap(Map<String, Integer> map) {
    //напишите тут ваш код
    Map<String,Integer> newMap = new HashMap<>(map);
    Set<Map.Entry<String, Integer>> set = newMap.entrySet();
    set.stream()
            .filter(i -> i.getValue()<500)
            .forEach(i -> map.remove(i.getKey(),i.getValue()));
  }

  public static void main(String[] args) {
    Map<String,Integer> map = createMap();
    removeItemFromMap(map);
    System.out.println(map);
  }
}
