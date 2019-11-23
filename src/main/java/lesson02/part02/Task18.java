package lesson02.part02;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

/**
 * Ввести с клавиатуры два целых числа, и вывести на экран минимальное из них. Если два числа равны между собой, необходимо вывести любое.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить число на экран.
 * 3.	Программа должна выводить на экран минимальное из двух целых чисел.
 * 4.	Если два числа равны между собой, необходимо вывести любое.
 */

public class Task18 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Comp comp = new Comp();
        System.out.println("Введите два целых числа: ");
        comp.x = scanner.nextInt();
        comp.y = scanner.nextInt();
        comp.comparing(comp.x, comp.y);
    }
        public static class Comp{
            public int x, y;

            public void comparing(int x, int y){
            this.x=x; this.y=y;
            if (x<y){System.out.println(x);}
            else {System.out.println(y);}            }
        }
}
