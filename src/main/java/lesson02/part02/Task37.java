package lesson02.part02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
 * Пример вывода на экран:
 * 8
 * 88
 * 888
 * 8888
 * 88888
 * 888888
 * 8888888
 * 88888888
 * 888888888
 * 8888888888
 * <p>
 * <p>
 * Требования:
 * 1.	Программа не должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить числа на экран.
 * 3.	Программа должна выводить прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
 * 4.	В программе должен использоваться цикл for.
 */

public class Task37 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите n");
        String a=reader.readLine();
        int m=Integer.parseInt(a);
        System.out.println("Введите m");
        String c=reader.readLine();
        int n=Integer.parseInt(c);
        for(int g=1;g<=m; g++) {
            for (int i=1; i<=n; i++) {
                System.out.print("8");
            }
            System.out.println();
        }
    }
}
