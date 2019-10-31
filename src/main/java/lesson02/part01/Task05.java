package lesson02.part01;

import java.time.LocalDate;
import java.time.Month;

/**
 * Вывести на экран дату своего рождения в виде: MAY 1 2012
 * <p>
 * <p>
 * Требования:
 * 1.	Выводимый текст должен содержать месяц, день и год, разделенные пробелом.
 * 2.	Название месяца должно выводиться на английском языке и заглавными буквами.
 * 3.	Год должен состоять из четырех цифр и быть не меньше 1900.
 * 4.	Дата рождения должна предшествовать текущей.
 */

public class Task05 {
    public static void main(String[] args) {
        //напишите тут ваш код
        LocalDate date = LocalDate.of(1998, Month.JULY, 31);
        System.out.println(date.getMonth() + " " + date.getDayOfMonth() + " " + date.getYear());
    }
}
