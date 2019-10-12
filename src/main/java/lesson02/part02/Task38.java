package lesson02.part02;

/**
 * Используя цикл for вывести на экран:
 * - горизонтальную линию из 10 восьмёрок
 * - вертикальную линию из 10 восьмёрок (символ из горизонтальной линии не учитывается).
 * <p>
 * <p>
 * Требования:
 * 1.	Программа не должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить числа на экран.
 * 3.	Программа должна выводить горизонтальную линию из 10 восьмёрок.
 * 4.	Программа должна выводить вертикальную линию из 10 восьмёрок.
 * 5.	В программе должен использоваться цикл for.
 */

public class Task38 {
    public static void main(String[] args) {
        for (int i = 0; i<10; i++){
            System.out.print(8);
        }
        System.out.println("");
        for (int n = 0; n<10; n++){
            System.out.println(8);
        }
    }
}
