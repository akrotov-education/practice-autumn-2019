package lesson02.part01;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;


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
        LocalDateTime birthDate = LocalDateTime.of(1997,Month.NOVEMBER,10,0,0);
        System.out.print(birthDate.getMonth());
        System.out.print(" " + birthDate.getDayOfMonth());
        System.out.print(" " + birthDate.getYear());
    }
}
