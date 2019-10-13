package lesson02.part01.task0313;

/* 
Мама мыла раму
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String[] words = {"Мама", "Мыла", "Раму"};

        System.out.printf("%s%s%s\n",words[0], words[1], words[2]);
        System.out.printf("%s%s%s\n",words[0], words[2], words[1]);
        System.out.printf("%s%s%s\n",words[1], words[0], words[2]);
        System.out.printf("%s%s%s\n",words[1], words[2], words[0]);
        System.out.printf("%s%s%s\n",words[2], words[0], words[1]);
        System.out.printf("%s%s%s\n",words[2], words[1], words[0]);
    }
}
