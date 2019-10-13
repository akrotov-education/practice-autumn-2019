package lesson02.part01.task0318;

/* 
План по захвату мира
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String name;
        Scanner s = new Scanner(System.in);
        name = s.nextLine();
        int years;
        years = s.nextInt();
        System.out.println(name + " захватит мир через " +  years + " лет. Му-ха-ха!");
    }
}
