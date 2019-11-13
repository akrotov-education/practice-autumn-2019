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
        Scanner in=new Scanner(System.in);
        int n=5;
        int numbers []=new int[n];
        for (int i=0;i<n;i++)
            numbers[i] = in.nextInt();

        for (int i=1;i<n;i++){
            if(numbers[i]>numbers[i-1]){
                int x=numbers[i];
                numbers[i]=numbers[i-1];
                numbers[i-1]=x;
                for (int j=i-1;j!=0;j--){
                    if(numbers[j]>numbers[j-1]){
                        int y=numbers[j];
                        numbers[j]=numbers[j-1];
                        numbers[j-1]=y;
                    }
                }
            }
        }

        for(int i=0;i<n;i++)
            System.out.print(numbers[i]+" ");

    }
}
