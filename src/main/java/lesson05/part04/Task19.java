package lesson05.part04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * НОД
 * Наибольший общий делитель (НОД).
 * Ввести с клавиатуры 2 целых положительных числа.
 * Вывести в консоль наибольший общий делитель.
 * <p>
 * <p>
 * Требования:
 * 1. Программа должна считывать с клавиатуры 2 строки.
 * 2. В случае если введенные строки невозможно преобразовать в положительные целые числа, должно возникать исключение.
 * 3. Программа должна выводить данные на экран.
 * 4. Программа должна выводить на экран наибольший общий делитель(НОД) чисел считанных с клавиатуры и успешно завершаться.
 */

public class Task19 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        if (a <= 0) throw new Exception();
        int b = Integer.parseInt(reader.readLine());
        if (b <= 0) throw new Exception();
        System.out.println(gcd(a, b));
    }

    public static int gcd(int a, int b) {
        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
