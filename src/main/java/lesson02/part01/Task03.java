package lesson02.part01;

/**
 * Напиши код метода convertEurToUsd, который переводит евро в доллары по заданному курсу.
 * Для возврата результата из метода convertEurToUsd используй оператор return. Пример: return 123*435;
 * Вызови метод convertEurToUsd дважды в методе main с любыми параметрами. Результаты выведи на экран, каждый раз с новой строки.
 * Подсказка:
 * Расчет выполняется по формуле: долларСША = евро * курс
 * <p>
 * <p>
 * Требования:
 * 1.	Метод convertEurToUsd должен умножать евро на курс и возвращать полученный результат.
 * 2.	Метод main должен 2 раза вызвать метод convertEurToUsd с любыми параметрами.
 * 3.	Метод main должен выводить результаты вызовов на экран, каждый раз с новой строки.
 * 4.	Метод convertEurToUsd не должен ничего выводить на экран.
 */

public class Task03 {
    public static void main(String[] args) {
    System.out.print(convertEurToUsd(10, 2));
    System.out.print(convertEurToUsd(15, 2));
    }


    public static double convertEurToUsd(int eur, double course) {
        double res=eur*course;
        return res;
    }
}
