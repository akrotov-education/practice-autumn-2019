package lesson03.part01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Вывести на экран текущую дату в аналогичном виде "21 02 2014".
 * <p>
 * Требования:
 * 1.	Дата должна содержать день, месяц и год, разделенные пробелом.
 * 2.	День должен соответствовать текущему.
 * 3.	Месяц должен соответствовать текущему.
 * 4.	Год должен соответствовать текущему.
 * 5.	Вся дата должна быть выведена в одной строке.
 */

public class Task17 {

  public static void main(String[] args) {
    DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
    System.out.println(dateFormat.format(new Date()));
  }
}