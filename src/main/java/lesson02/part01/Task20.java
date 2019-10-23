package lesson02.part01;

import java.util.*;

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
        //напишите тут ваш код
        List<String> names = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите имя");
            names.add(input.nextLine());
        }
        System.out.println(names.get(0) + " + " + names.get(1) + " + " + names.get(2) + " = Чистая любовь, да-да!");
    }
}