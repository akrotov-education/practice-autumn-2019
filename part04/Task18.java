package lesson05.part04;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Нашествие исключений
 * Заполни список exceptions десятью(10) различными исключениями.
 * Первое исключение уже реализовано в методе initExceptions.
 * <p>
 * <p>
 * Требования:
 * 1. Список exceptions должен содержать 10 элементов.
 * 2. Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
 * 3. Все элементы списка exceptions должны быть уникальны.
 * 4. Метод initExceptions должен быть статическим.
 */

public class Task18 {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();
        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) { exceptions.add(e); }
        try {
            int arr[] = {1,2};
            int a = arr[2];
        } catch (Exception e) { exceptions.add(e); }
        try {
            FileInputStream fis = new FileInputStream("C:\\kek.txt");
        } catch (Exception e) { exceptions.add(e); }
        try {
            int[] i = null;
            i.toString();
        } catch (Exception e) { exceptions.add(e); }
        try {
            Task18 sol = new Task18();
            sol.clone();
        }
        catch (Exception e) { exceptions.add(e); }
        try {
            String s = "lolkek";
            int i = Integer.parseInt(s);
        }
        catch (Exception e) { exceptions.add(e); }
        try {
            Object x = new Integer(0);
            System.out.println((String)x);
        }
        catch (Exception e) { exceptions.add(e); }
        try {
            Object szStr[] = new String[10];
            szStr[0] = new Character('*');
        }
        catch (Exception e) { exceptions.add(e); }
        try {
            String szShortString = "123";
            char chr = szShortString.charAt(10);
        }
        catch (Exception e) { exceptions.add(e); }
        try {
            throw new IllegalStateException("MyException");
        }
        catch (Exception e) { exceptions.add(e); }
    }
}
