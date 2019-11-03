package lesson04.part02;

import java.util.HashMap;
import java.util.Map;

/**
 * Создать коллекцию Map<String, String> (реализация HashMap), занести туда 10 пар строк:
 * арбуз - ягода,
 * банан - трава,
 * вишня - ягода,
 * груша - фрукт,
 * дыня - овощ,
 * ежевика - куст,
 * жень-шень - корень,
 * земляника - ягода,
 * ирис - цветок,
 * картофель - клубень.
 * Вывести содержимое коллекции на экран, каждый элемент с новой строки.
 *
 * Пример вывода (тут показана только одна строка):
 * картофель - клубень
 *
 * Требования:
 * 1.	Объяви переменную коллекции Map с типом элементов String, String и сразу проинициализируй ee.
 * 2.	Программа не должна считывать значения с клавиатуры.
 * 3.	Программа должна добавлять в коллекцию 10 пар строк, согласно условию.
 * 4.	Программа должна выводить содержимое коллекции на экран, каждую пару с новой строки.
 */

public class Task22 {

  public static void main(String[] args) {
    //напишите тут ваш код
    Map<String, String> map = new HashMap<>();
    map.put("арбуз","ягода");
    map.put("банан","трава");
    map.put("вишня","ягода");
    map.put("груша","фрукт");
    map.put("дыня","овощ");
    map.put("ежевика","куст");
    map.put("жень-шень","корень");
    map.put("земляника","ягода");
    map.put("ирис","цветок");
    map.put("картофель","клубень");

    map.forEach((s, s2) -> System.out.println(String.format("%s - %s", s,s2)));
  }
}
