package lesson02.part01.task0305;

/* 
Я так давно родился
*/

import java.time.LocalDate;
import java.time.Month;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        LocalDate date = LocalDate.of(1998, Month.JULY, 31);
        System.out.println(date.getMonth() + " " + date.getDayOfMonth() + " " + date.getYear());
    }
}
