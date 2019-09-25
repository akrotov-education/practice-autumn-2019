package com.company;
import java.time.LocalDateTime;
public class Task03_1 {
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
        LocalDateTime date1 = LocalDateTime.now();
        int date2 = date1.getYear();
        int date3 = date2 - 98;
        System.out.println("Сейчас " + date2 + " год. Наш университет основан в " + date3 + " году.");
    }
}
