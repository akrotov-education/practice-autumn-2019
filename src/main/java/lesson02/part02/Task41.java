package lesson02.part02;

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
import java.io.*;
import java.util.*;


public class Task41 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int c1, c2, c3;
        System.out.print("Введите данные \n");
        String cS = bufferedReader.readLine();
        c1 = Integer.parseInt(cS);
        cS = bufferedReader.readLine();
        c2 = Integer.parseInt(cS);
        cS = bufferedReader.readLine();
        c3 = Integer.parseInt(cS);
        if((c1<c2&&c2<c3)||(c1>c2&&c2>c3))
            System.out.print(c2);
        if((c1>c2&&c1<c3)||(c1<c2&&c1>c3))
            System.out.print(c1);
        if((c3<c2&&c1<c3)||(c3>c2&&c1>c3))
            System.out.print(c3);
    }
}
