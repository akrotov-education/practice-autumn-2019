package lesson02.part02;

/**
 * Вывести на экран числа от 10 до 1 используя цикл while. Каждое значение с новой строки.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа не должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить числа на экран.
 * 3.	Каждое значение должно быть выведено с новой строки.
 * 4.	Программа должна выводить числа от 10 до 1.
 * 5.	В программе должен использоваться цикл while.
 */

public class Task31 {
    public static void main(String[] args) {
        int i = 10;

        while (i > 0) {
            System.out.println(i);
            i--;
        }
    }
}
