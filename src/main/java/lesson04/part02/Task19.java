package lesson04.part02;

import java.util.HashMap;
import java.util.Map;

/**
 * Есть коллекция Map<String, Object> (реализация HashMap), туда занесли 10 различных пар объектов.
 * Вывести содержимое коллекции на экран, каждый элемент с новой строки.
 * <p>
 * Пример вывода (тут показана только одна строка):
 * Sim - 5
 * <p>
 * Требования:
 * 1.	Программа должна создавать переменную коллекции Map с типом элементов String, Object.
 * Переменная должна быть сразу проинициализирована.
 * 2.	Программа не должна считывать значения с клавиатуры.
 * 3.	Программа должна добавлять в коллекцию 10 различных объектов, согласно условию.
 * 4.	Программа должна выводить содержимое коллекции на экран, каждую пару с новой строки.
 */

public class Task19 {

  public static void main(String[] args) {
    Map<String, Object> map = new HashMap<>();
    map.put("Sim", 5);
    map.put("Bat", 6.5);
    map.put("Dog", (double) 1253);
    map.put("Bus", true);
    map.put("Baby", null);
    map.put("Cat", "Cat");
    map.put("Box", Character.valueOf('1'));
    map.put("Colour", '6');
    map.put("Mug", 121L);
    map.put("Beat", Long.valueOf(56));

    for (Map.Entry<String, Object> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }

  }
}