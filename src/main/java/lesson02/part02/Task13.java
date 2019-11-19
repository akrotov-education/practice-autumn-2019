package lesson02.part02;

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

import java.io.*;
import java.util.*;


public class Task13 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.print("Введите число ");
        String cN = bufferedReader.readLine();
        switch (cN){
            case "1":
                System.out.println("Понедельник");
                break;
            case "2":
                System.out.println("Вторник");
                break;
            case "3":
                System.out.println("Среда");
                break;
            case "4":
                System.out.println("Четверг");
                break;
            case "5":
                System.out.println("Пятница");
                break;
            case "6":
                System.out.println("Суббота");
                break;
            case "7":
                System.out.println("Воскресение");
            default:
                System.out.println("Нет такого");
        }

    }
}