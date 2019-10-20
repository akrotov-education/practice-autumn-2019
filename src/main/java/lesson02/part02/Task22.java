package lesson02.part02;

import java.util.Scanner;

/**
 * Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще».
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна дважды считать данные c клавиатуры.
 * 2.	Программа должна использовать команду System.out.println() или System.out.print().
 * 3.	Если возраст меньше 18 вывести только сообщение "Подрасти еще".
 * 4.	Если возраст больше либо равно 18 ничего не выводить.
 */

public class Task22 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        int int1 = scanner.nextInt();
        if (int1<18){
            System.out.println("Подрасти еще");
        }
    }
}