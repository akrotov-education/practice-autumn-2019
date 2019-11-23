package lesson02.part02;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

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
        int x;
        System.out.println("Введите номер дня недели: ");
        x = scanner.nextInt();
        if (x==1){System.out.println("понедельник");}
        if (x==2){System.out.println("вторник");}
        if (x==3){System.out.println("среда");}
        if (x==4){System.out.println("четверг");}
        if (x==5){System.out.println("пятница");}
        if (x==6){System.out.println("суббота");}
        if (x==7){System.out.println("воскресенье");}
        else {System.out.println("Такого дня недели не существует");}
    }
}