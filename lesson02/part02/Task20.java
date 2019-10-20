package lesson02.part02;

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
        int num1, num2, num3;
        Scanner in = new Scanner(System.in);
        num1 = in.nextInt();
        num2 = in.nextInt();
        num3 = in.nextInt();
        int[] arr = {num1, num2, num3};

        for (int i=arr.length-1; i>0; i--){
            for (int k=0; k<i; k++){
                if (arr[k]<arr[k+1]){
                    int tmp = arr[k];
                    arr[k]=arr[k+1];
                    arr[k+1]=tmp;
                }
            }
        }
        //System.out.print(arr[0] + " " + arr[1] + " " + arr[2]);
        System.out.printf("%d %d %d", arr[0], arr[1], arr[2]);
    }
}
