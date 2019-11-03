package lesson04.part02;

import java.sql.Time;
import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Измерить, сколько времени занимает 10 тысяч вставок для каждого списка.
 * Метод getInsertTimeInMs должен вернуть время своего исполнения в миллисекундах.
 *
 * Требования:
 * 1.	Программа должна выводить числа на экран.
 * 2.	Метод main должен вызывать метод getInsertTimeInMs только два раза.
 * 3.	Метод insert10000(List list) должен вставлять 10 тысяч элементов в список.
 * 4.	Метод getInsertTimeInMs должен вызывать метод insert10000 только один раз.
 * 5.	Метод getInsertTimeInMs должен вернуть время в миллисекундах, которое занимает 10 тысяч вставок в список.
 */

public class Task29 {

  public static void main(String[] args) {
    System.out.println(getInsertTimeInMs(new ArrayList()));
    System.out.println(getInsertTimeInMs(new LinkedList()));
  }

  public static long getInsertTimeInMs(List list) {
    // напишите тут ваш код
    LocalTime timeNow = LocalTime.now();

    insert10000(list);

    // напишите тут ваш код
    LocalTime timeAfter = LocalTime.now();
    return (timeAfter.getNano() - timeNow.getNano())/1000000;
  }

  public static void insert10000(List list) {
    for (int i = 0; i < 10000; i++) {
      list.add(0, new Object());
    }
  }
}
