package lesson02.part02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
 * Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
 * Примеры:
 * а) при вводе чисел
 * 1
 * 2
 * 2
 * получим вывод
 * 2 2
 * <p>
 * б) при вводе чисел
 * 2
 * 2
 * 2
 * получим вывод
 * 2 2 2
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна содержать System.out.println() или System.out.print()
 * 3.	Если два числа равны между собой, необходимо вывести числа на экран.
 * 4.	Если все три числа равны между собой, необходимо вывести все три.
 * 5.	Если нет равных чисел, ничего не выводить.
 */

public class Task17 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите первое число");
        String a = reader.readLine();
        int A = Integer.parseInt(a);

        System.out.println("Введите второе число");
        String b = reader.readLine();
        int B = Integer.parseInt(b);

        System.out.println("Введите третье число");
        String c = reader.readLine();
        int C = Integer.parseInt(c);

        if ((A==B) && (A==C)) {
            System.out.println(A + " " + B + " " + C );
        }
        else if (A == B) {
            System.out.println(A + " " + B);
        }
        else if (A == C) {
            System.out.println(A + " " + C);
        }
        else if (B == C) {
            System.out.println(B + " " + C);
        }
    }
}