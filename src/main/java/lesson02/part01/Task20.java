package lesson02.part01;

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
import java.util.Scanner;
public class Task20 {
    public static void main(String[] args) throws Exception {
        String name1,name2, name3;

        Scanner in = new Scanner(System.in);
        name1 = in.next();
        name2 = in.next();
        name3 = in.next();
System.out.println(name1+" + "+name2+" + "+name3+" = Чистая любовь, да-да");
    }
}