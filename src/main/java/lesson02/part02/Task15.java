package lesson02.part02;

/**
 * Ввести с клавиатуры три числа а, b, c – стороны предполагаемого треугольника.
 * Определить возможность существования треугольника по сторонам. Результат вывести на экран в следующем виде:
 * "Треугольник существует." - если треугольник с такими сторонами существует.
 * "Треугольник не существует." - если треугольник с такими сторонами не существует.
 * Подсказка: Треугольник существует только тогда, когда сумма любых двух его сторон больше третьей.
 * Требуется сравнить каждую сторону с суммой двух других.
 * Если хотя бы в одном случае сторона окажется больше суммы двух других, то треугольника с такими сторонами не существует.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать три числа c клавиатуры.
 * 2.	Программа должна выводить текст на экран согласно условия задачи.
 * 3.	Если треугольник с такими сторонами может существовать, необходимо вывести текст: "Треугольник существует."
 * 4.	Если треугольник с такими сторонами не может существовать, необходимо вывести текст: "Треугольник не существует."
 */


import java.io.*;
import java.util.*;

public class Task15 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int a,b,c;
        System.out.print("Введите данные ");
        String cS = bufferedReader.readLine();
        a = Integer.parseInt(cS);
        cS = bufferedReader.readLine();
        b = Integer.parseInt(cS);
        cS = bufferedReader.readLine();
        c = Integer.parseInt(cS);

        int ab=a+b,ac=a+c,bc=b+c;
        if(ac>b && ab>c && bc>a)
            System.out.print("Существует");
        else
            System.out.print("Нет");



    }
}