package lesson02.part01.task0309;

/* 
Сумма 5 чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int sum = 0;
        for(int i = 0; i < 5; ++i){
            System.out.println(sum += (i+1));
        }
    }
}
