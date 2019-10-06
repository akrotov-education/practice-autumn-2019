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
        LocalDateTime inTime = LocalDateTime.of(2019, 9, 25, 15, 0, 0);
        LocalDateTime outTime = LocalDateTime.of(2019, 9, 25, 15, 30, 0);
        int secondsAfter15 = (int) ChronoUnit.SECONDS.between(inTime, outTime);
        System.out.println(secondsAfter15);
    }
}
