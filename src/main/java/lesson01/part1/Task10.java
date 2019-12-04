package lesson01.part1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Task10 {

    /**
     * Не думать о секундах…
     * Напиши код, который считает сколько секунд прошло с 15:00, если на часах 15:30. Выведи результат на экран.
     * <p>
     * <p>
     * Требования:
     * 1. Программа должна выводить текст.
     * 2. Выведенный текст должен быть целым положительным числом.
     * 3. Выведенное число должно быть кратно 60.
     * 4. Выводимое число должно соответствовать заданию.
     */

    public static void main(String[] args) {
        LocalDateTime initTime = LocalDateTime.of(2019, 9, 22, 15, 0);
        LocalDateTime endTime = LocalDateTime.of(2019, 9, 22, 15, 30);

        long secondsAfter15 = ChronoUnit.SECONDS.between(initTime, endTime);
        String otvet = Long.toString(secondsAfter15);
        System.out.print(otvet);
    }
}
