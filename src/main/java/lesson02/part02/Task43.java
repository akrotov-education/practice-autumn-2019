package lesson02.part02;

import java.util.Scanner;

/**
 * Ввести с клавиатуры строку name.
 * Ввести с клавиатуры дату рождения (три числа): y, m, d.
 * Вывести на экран текст:
 * «Меня зовут name.
 * Я родился d.m.y»
 * <p>
 * Пример вывода:
 * Меня зовут Вася.
 * Я родился 15.2.1988
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать строки c клавиатуры.
 * 2.	Программа должна выводить строки на экран.
 * 3.	Программа должна выводить текст, шаблон которого указан в задании.
 * 4.	Каждое предложение вывести с новой строки.
 */

public class Task43 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
    	Scanner in = new Scanner(System.in);
     	String name = in.nextLine();
     	int y = in.nextInt();
     	int m = in.nextInt();
     	int d = in.nextInt();
     	System.out.println("Меня зовут " + name);
     	System.out.println(String.format("Я родился %d.%d.%d", d, m, y));
	 	in.close();
    }
}
