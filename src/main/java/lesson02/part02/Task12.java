package lesson02.part02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Ввести с клавиатуры число. Если число положительное, то увеличить его в два раза. Если число отрицательное, то прибавить единицу.
 * Если введенное число равно нулю, необходимо вывести ноль.
 * Вывести результат на экран.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать число c клавиатуры.
 * 2.	Программа должна выводить число на экран.
 * 3.	Если введенное число положительное, необходимо увеличить его в два раза и вывести.
 * 4.	Если введенное число отрицательное, необходимо увеличить его на единицу и вывести.
 * 5.	Если введенное число равно нулю, необходимо вывести ноль.
 */

public class Task12 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int x;
        System.out.println("Введите число: ");
        x = scanner.nextInt();
        if(x>0) {
            x*=2;
            System.out.println(x);
        }
        else if (x<0){
            x+=1;
            System.out.println(x);
        }
        else System.out.println(x);
    }

}