package lesson04.part02;

import java.util.HashMap;
import java.util.Iterator;
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

    Map<String, String> mas = new HashMap<String, String>();

    mas.put("арбуз","ягода");
    mas.put("банан","трава");
    mas.put("вишня","ягода");
    mas.put("груша","фрукт");
    mas.put("дыня","овощ");
    mas.put("ежевика","куст");
    mas.put("жень-шень","корень");
    mas.put("земляника","ягода");
    mas.put("ирис","цветок");
    mas.put("картофель","клубень");

    //System.out.print(mas.entrySet());
    //System.out.println(mas);

    //Iterator<String> iter = mas.iterator();
    Iterator<Map.Entry<String, String>> iterKey = mas.entrySet().iterator();
    Iterator<Map.Entry<String, String>> iterVal = mas.entrySet().iterator();

    while (iterKey.hasNext())
    {
      System.out.println(iterKey.next().getKey() + " - " + iterVal.next().getValue());
    }
  }
}
