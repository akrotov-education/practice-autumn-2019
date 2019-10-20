package lesson02.part02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя: ");
        String a=reader.readLine();
        System.out.println("Введите возраст: ");
        String b=reader.readLine();
        int c=Integer.parseInt(b);
        if(c<18)System.out.println("Подрасти еще");//напишите тут ваш код

    }
}
