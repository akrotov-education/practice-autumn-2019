package lesson01.part1;

import java.time.LocalTime;
import java.time.Duration;
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
        LocalTime start = LocalTime.of(15,00);
        LocalTime end = LocalTime.of(15,30);
        Duration d = Duration.between(start, end);;
        int secondsAfter15 = (int) d.getSeconds();
        System.out.println(secondsAfter15);
    }
}
