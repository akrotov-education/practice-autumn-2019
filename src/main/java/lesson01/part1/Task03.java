package lesson01.part1;

import java.time.LocalDate;

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
        LocalDate localDate = LocalDate.now();

        System.out.println(localDate.minusYears(98).getYear());
    }
}
