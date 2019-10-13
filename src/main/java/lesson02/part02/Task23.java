package lesson02.part02;

import java.util.Scanner;

/**
 * Ввести с клавиатуры имя и возраст. Если возраст больше 20 вывести надпись «И 18-ти достаточно».
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать строки c клавиатуры.
 * 2.	Программа должна использовать команду System.out.println() или System.out.print().
 * 3.	Если возраст больше 20 вывести только сообщение "И 18-ти достаточно".
 * 4.	Если возраст меньше либо равно 20 ничего не выводить.
 */

public class Task23 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name and age: ?");
        String string = scanner.nextLine();

        String[] separated = string.split(" ");

        if(separated.length == 2 && Integer.parseInt(separated[1]) > 20)
            System.out.println("И 18-ти достаточно");
    }
}
