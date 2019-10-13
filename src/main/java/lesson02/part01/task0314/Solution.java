package lesson02.part01.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        for(int i = 1; i <= 10; ++i){
            for(int j = 1; j <= 10; ++j){
                System.out.printf("%d ", i*j);
            }
            System.out.println();
        }
    }
}
