package lesson02.part02;

import java.util.ArrayList;
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
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i<3; i++){
            arr.add(scan.nextInt());
        }
        ArrayList<Integer> newArr = new ArrayList<>();
        while (arr.size()>0){
            for (int i = 0; i<arr.size(); i++){
                boolean f = false;
                for (int temp:arr){
                    if (temp< arr.get(i))
                        f = true;
                }
                if (!f){
                    newArr.add(arr.get(i));
                    arr.remove(arr.get(i));
                }
            }
        }
        for (int numb: newArr) {
            System.out.printf("%s ", numb);
        }
    }
}
