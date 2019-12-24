package lesson04.part02;

import java.util.HashMap;
import java.util.Map;

/**
 * Есть коллекция Map<String, String> (реализация HashMap), туда занесли 10 различных строк.
 * Вывести на экран список ключей, каждый элемент с новой строки.
 * <p>
 * Требования:
 * 1.	Программа должна создавать переменную коллекции Map с типом элементов String, String. Переменная должна быть сразу проинициализирована.
 * 2.	Программа не должна считывать значения с клавиатуры.
 * 3.	Программа должна добавлять в коллекцию 10 различных строк, согласно условию.
 * 4.	Метод printKeys() должен выводить на экран список ключей коллекции, каждый элемент с новой строки.
 */

public class Task18 {

  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("Sim", "Sim");
    map.put("Tom", "Tom");
    map.put("Arbus", "Arbus");
    map.put("Baby", "Baby");
    map.put("Cat", "Cat");
    map.put("Dog", "Dog");
    map.put("Eat", "Eat");
    map.put("Food", "Food");
    map.put("Gevey", "Gevey");
    map.put("Hugs", "Hugs");

    printKeys(map);
  }

  public static void printKeys(Map<String, String> map) {
    for (Map.Entry<String, String> entry : map.entrySet()) {
      System.out.println(entry.getKey());
    }
  }
}