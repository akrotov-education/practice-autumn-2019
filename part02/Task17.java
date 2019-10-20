package lesson02.part02;

/**
 * Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
 * Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
 * Примеры:
 * а) при вводе чисел
 * 1
 * 2
 * 2
 * получим вывод
 * 2 2
 * <p>
 * б) при вводе чисел
 * 2
 * 2
 * 2
 * получим вывод
 * 2 2 2
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна содержать System.out.println() или System.out.print()
 * 3.	Если два числа равны между собой, необходимо вывести числа на экран.
 * 4.	Если все три числа равны между собой, необходимо вывести все три.
 * 5.	Если нет равных чисел, ничего не выводить.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task17 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        int num3 = Integer.parseInt(reader.readLine());
        if ((num1 == num2) && (num2 == num3)){
            System.out.println(num1 + " " + num2 + " " + num3);
            System.out.println("<p>");
            System.out.println("<p>");}
        else if (num1 == num2){
            System.out.println(num1 + " " + num2);
            System.out.println("<p>");}
        else if ((num2 == num3)){
            System.out.println(num2 + " " + num3);
            System.out.println("<p>");}
        else if (num3 == num1){
            System.out.println(num1 + " " + num3);
            System.out.println("<p>");}

    }
}