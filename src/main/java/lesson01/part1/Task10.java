package lesson01.part1;
import java.time.LocalTime;
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
        int secondsAfter15 = 0;
        LocalTime date1 = LocalTime.of(15, 00, 00);
        int date11 = date1.getMinute();
        LocalTime date2 = LocalTime.of(15, 30, 00);
        int date22 = date2.getMinute();
        secondsAfter15 = (date22 - date11) * 60;
        System.out.println(secondsAfter15);
    }
}
