package lesson02.part01.task0313;

/* 
Мама мыла раму
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String[] strings = new String[]{"Мама", "Мыла", "Раму"};
        for (String s1: strings) {
            for (String s2: strings)
                if(!s2.equals(s1)) {
                    for (String s3 : strings)
                        if(!s3.equals(s1) && !s3.equals(s2)) {
                            System.out.println(s1 + s2 + s3);
                        }
                }
        }
    }
}
