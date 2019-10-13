package lesson02.part01.task0304;

/* 
Задача на проценты
*/

public class Solution {
    public static double addTenPercent(int i) {
        //напишите тут ваш код
        return i + (i / 10.0);
    }

    public static void main(String[] args) {
        System.out.println(addTenPercent(9));
    }
}
