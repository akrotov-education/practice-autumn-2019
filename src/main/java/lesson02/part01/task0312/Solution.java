package lesson02.part01.task0312;

/* 
Конвертируем время
*/

public class Solution {
    //напишите тут ваш код

    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(convertToSeconds(5));
        System.out.println(convertToSeconds(1));
    }

    public static int convertToSeconds(int hour) {
        return hour * 60 * 60;
    }
}
