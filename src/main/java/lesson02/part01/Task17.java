package lesson02.part01;

/**
 * Ввести с клавиатуры число и имя, вывести на экран строку:
 * «имя» захватит мир через «число» лет. Му-ха-ха!
 * Пример: Вася захватит мир через 8 лет. Му-ха-ха!
 * <p>
 * Последовательность вводимых данных имеет большое значение.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна выводить текст.
 * 2.	Программа должна считывать данные с клавиатуры.
 * 3.	Выведенный текст должен содержать введенное имя.
 * 4.	Выведенный текст должен содержать введенное число.
 * 5.	Выведенный текст должен полностью соответствовать заданию.
 */

import java.util.*;

public class Task17 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name: ?");
        String name = scanner.nextLine();

        System.out.println("Years: ?");
        int years = scanner.nextInt();

        System.out.println(name + " захватит мир через " + years + " лет. Му-ха-ха!");
    }
}
