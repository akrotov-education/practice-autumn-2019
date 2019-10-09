package lesson02.part01.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        Scanner scanner = new Scanner(System.in);

        System.out.println("Name: ?");
        String name = scanner.nextLine();

        System.out.println("Value: ?");
        int value = scanner.nextInt();

        System.out.println("Years: ?");
        int years = scanner.nextInt();

        System.out.println(name + " получает " + value + " через " + years + " лет.");
    }
}
