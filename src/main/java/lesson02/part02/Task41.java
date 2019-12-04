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
        Scanner in=new Scanner(System.in);
//        int a=in.nextInt();
//        int b=in.nextInt();
//        int c=in.nextInt();
        int n=3;
        int numbers[]=new int[n];
        for(int i=0;i<n;i++){
            numbers[i]=in.nextInt();
        }
        for (int i=1;i<n;i++){
            if(numbers[i]<numbers[i-1]){
                int x=numbers[i];
                numbers[i]=numbers[i-1];
                numbers[i-1]=x;
                for (int j=i-1;j!=0;j--){
                    if(numbers[j]<numbers[j-1]){
                        int y=numbers[j];
                        numbers[j]=numbers[j-1];
                        numbers[j-1]=y;
                    }
                }
            }
        }

        System.out.println(numbers[(n/2)]);
    }
}
