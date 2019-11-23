package lesson02.part02;

import java.util.Scanner;

/**
 * Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
 * Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
 * Примеры:
 * а) при вводе чисел
 * 1
 * 2
 * 2
 * получим вывод
 * 2 2
 * <p>
 * б) при вводе чисел
 * 2
 * 2
 * 2
 * получим вывод
 * 2 2 2
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна содержать System.out.println() или System.out.print()
 * 3.	Если два числа равны между собой, необходимо вывести числа на экран.
 * 4.	Если все три числа равны между собой, необходимо вывести все три.
 * 5.	Если нет равных чисел, ничего не выводить.
 */

public class Task17 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Compare compare = new Compare();
        System.out.println("Введите x, y, z: ");
        compare.x = scanner.nextInt();
        compare.y = scanner.nextInt();
        compare.z = scanner.nextInt();
        compare.comparing(compare.x, compare.y, compare.z);
    }
        public static class Compare {
            public int x, y, z;

            public void comparing(int x, int y, int z) {
                this.x=x; this.y=y; this.z=z;
                if (x == y && x != z && y != z) System.out.println(x + " " + y);
                if (x == z && x != y && y != z) System.out.println(x + " " + z);
                if (y == z && y != x && x != z) System.out.println(y + " " + z);
                if (x == y && y == z && x == z) System.out.println(x + " " + y + " " + z);
                else System.out.print("");
            }
        }
}