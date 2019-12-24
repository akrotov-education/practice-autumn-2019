package lesson02.part01;

/**
 * Добавь метод public static int convertToSeconds(int hour) который будет конвертировать часы в секунды.
 * Вызови его дважды в методе main с любыми параметрами. Результаты выведи на экран, каждый раз с новой строки.
 * <p>
 * <p>
 * Требования:
 * 1.	Добавь метод convertToSeconds, он должен быть public static, возвращать и принимать int.
 * 2.	Метод convertToSeconds должен переводить переданные часы в секунды.
 * 3.	Метод main должен дважды вызывать метод convertToSeconds.
 * 4.	Метод main должен выводить результаты вызова на экран, каждый раз с новой строки.
 * 5.	Метод convertToSeconds не должен ничего выводить на экран.
 */

public class Task11 {
    //напишите тут ваш код

    public static void main(String[] args) {
    System.out.println(convertToSeconds(3));
    System.out.println(convertToSeconds(16));
    }

    public static int convertToSeconds(int hour) {
        int i = hour * 3600;
        return i;
    }
}
