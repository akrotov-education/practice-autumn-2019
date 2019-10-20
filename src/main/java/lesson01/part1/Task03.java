package lesson01.part1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Task03 {

    /**
     * Мой юный друг
     * Сейчас 2019 год. Наш университет основан 98 лет назад.
     * Написать программу, выводящую на экран год основания МТУСИ.
     *
     * Требования:
     * 1. Программа должна выводить текст.
     * 2. Выведенный год должен состоять из 4 цифр.
     * 3. Выведенный год должен начинаться с "19".
     * 4. Выведенный год должен соответствовать заданию.
     */

    public static void main(String[] args) {
        // Напишите здесь ваш код
        LocalDate currentdate = LocalDate.now();
        int y = currentdate.getYear();
        System.out.println("Мтуси основан в " + (y - 98) + " году");

    }
}
