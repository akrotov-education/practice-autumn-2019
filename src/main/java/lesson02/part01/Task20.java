package lesson02.part01;

import java.util.Scanner;

/**
 * Ввести с клавиатуры три имени, вывести на экран надпись:
 * name1 + name2 + name3 = Чистая любовь, да-да!
 * Пример: Вася + Ева + Анжелика = Чистая любовь, да-да!
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна выводить текст.
 * 2.	Программа должна считывать данные с клавиатуры.
 * 3.	Выведенный текст должен содержать введенное имя name1.
 * 4.	Выведенный текст должен содержать введенное имя name2.
 * 5.	Выведенный текст должен содержать введенное имя name3.
 * 6.	Выведенный тест должен полностью соответствовать заданию.
 */

public class Task20 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String name1 = scan.nextLine();
        String name2 = scan.nextLine();
        String name3 = scan.nextLine();
        System.out.print(name1);
        System.out.print(" + ");
        System.out.print(name2);
        System.out.print(" + ");
        System.out.print(name3);
        System.out.print(" = Чистая любовь, да-да!");
    }
}