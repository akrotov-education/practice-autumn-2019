package lesson01.part1;
<<<<<<< HEAD
import java.time.LocalTime;
=======
>>>>>>> 63ed5ccc4a76e65d25aa84e4a9540f22d1e60c19

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
<<<<<<< HEAD
        LocalTime time1 = LocalTime.of(15,0,0);
        LocalTime time2 = LocalTime.of(15,30,0);
        int secondsAfter15 = (time2.getMinute() - time1.getMinute())*60 ;
        System.out.println(secondsAfter15);
=======
>>>>>>> 63ed5ccc4a76e65d25aa84e4a9540f22d1e60c19
    }
}
