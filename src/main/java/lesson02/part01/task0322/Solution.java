package lesson02.part01.task0322;

/* 
Большая и чистая
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        Scanner scanner = new Scanner(System.in);
        String names = "";
        for(int i=0; i < 3; i++)
        {
            System.out.println(i + 1 + " name: ?");
            names += " + " + scanner.nextLine();
        }

        System.out.println(names.replaceFirst(" \\+ ", "") + " = Чистая любовь, да-да!");
    }
}