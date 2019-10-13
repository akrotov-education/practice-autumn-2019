package lesson02.part01.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(System.in);
        String name;
        int num1, num2;
        name = s.nextLine();
        num1 = s.nextInt();
        num2 = s.nextInt();
        System.out.println(name + " получает "+ num1 +" через " + num2 +" лет.");
    }
}
