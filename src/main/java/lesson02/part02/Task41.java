package lesson02.part02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
 * Если все числа равны, вывести любое из них.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить число на экран.
 * 3.	Программа должна выводить среднее из трех чисел.
 * 4.	Если все числа равны, вывести любое из них.
 * 5.	Если два числа из трех равны, вывести любое из двух.
 */

public class Task41 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sFirst = br.readLine();
        String sSecond = br.readLine();
        String sThird = br.readLine();
        int a = Integer.parseInt(sFirst);
        int b = Integer.parseInt(sSecond);
        int c = Integer.parseInt(sThird);

        int tmp;
        if (a > b)
        {
            tmp = a;
            a = b;
            b = tmp;
        }
        if (b > c)
        {
            b = c;
        }
        if (a > b)
        {
            b = a;
        }
        System.out.println(b);

    }
}
