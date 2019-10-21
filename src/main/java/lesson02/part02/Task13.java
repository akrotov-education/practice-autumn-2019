package lesson02.part02;

import java.util.Scanner;

/**
 * Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название
 * «понедельник», «вторник», «среда», «четверг», «пятница», «суббота», «воскресенье»,
 * если введен номер больше 7 или меньше 1 – вывести «такого дня недели не существует».
 * Пример для номера 5:
 * пятница
 * Пример для номера 10:
 * такого дня недели не существует
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать число c клавиатуры.
 * 2.	Программа должна выводить текст на экран.
 * 3.	Если введено число от 1 до 7, необходимо вывести день недели.
 * 4.	Если введено число не входящее в интервал от 1 до 7, то вывести уведомление что такого дня недели не существует.
 */

public class Task13 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        if (day==1){
            System.out.println("понедельник");
        }
        else if (day==2){
            System.out.println("вторник");
        }
        else if (day==3){
            System.out.println("среда");
        }
        else if (day==4){
            System.out.println("четверг");
        }
        else if (day==5){
            System.out.println("пятница");
        }
        else if (day==6){
            System.out.println("суббота");
        }
        else if (day==7){
            System.out.println("воскресенье");
        }
        else if ((day>7)||(day<1)){
            System.out.println("такого дня недели не существует");
        }
    }
}