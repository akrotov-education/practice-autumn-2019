package lesson02.part01.task0318;

/* 
План по захвату мира
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name: ?");
        String name = scanner.nextLine();

        System.out.println("Years: ?");
        int years = scanner.nextInt();

        System.out.println(name + " захватит мир через " + years + " лет. Му-ха-ха!");
    }
}
