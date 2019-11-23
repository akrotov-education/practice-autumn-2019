package lesson02.part02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ввести с клавиатуры три числа, и вывести их в порядке убывания. Выведенные числа должны быть разделены пробелом.
 *
 *
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить числа на экран.
 * 3.	Программа должна выводить три числа разделенных пробелами.
 * 4.	Программа должна выводить числа в порядке убывания.
*/

public class Task20 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner (System.in);
        System.out.println("Введите три числа: ");
        int[] numbers = new int[3];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);
        System.out.println(numbers[2]+" "+numbers[1]+" "+numbers[0]);
        sc.close();
    }
 /*   public static int max(int a, int b, int c){
        int max;
        if (a>b && a>c) {max=a;}
        else if (b>a && b>=c) {max=b;}
        else if (c>a && c>=b) {max=c;}
        else {max=a;};
        return max;
    }
    public static int min(int a, int b, int c){
        int min;
        if (a<b && a<c) {min=a;}
        else if (b<c && b<=a) {min=b;}
        else if (c<a && c<=b){min=c;}
        else {min=a;}
        return min;
    }
    public static int aver(int a, int b, int c){
        int aver;
        if ( (a>b && a<c) || (a>c && a<b) ) {aver=a;}
        else if ( (b>a && b<c) || (b>c && b<a) ) {aver=b;}
        else {aver=a;}
        return aver;
    }*/
}
