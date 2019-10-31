package lesson02.part02;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        int[] values = new int[3];

        for(int i = 0; i < values.length; i++)
        {
            System.out.println("Value: ?");
            values[i] = scanner.nextInt();
        }

        int min = Math.min(Math.min(values[0], values[1]), values[2]);
        int max = Math.max(Math.max(values[0], values[1]), values[2]);


        for(int i = 0; i < values.length; i++)
        {
            if(values[i] < max && values[i] > min) {
                System.out.println(values[i]);
                return;
            }
        }

        System.out.println(values[0]);
    }
}
