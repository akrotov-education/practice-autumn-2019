package lesson02.part02;

/**
 * Вывести на экран квадрат из 10х10 букв S используя цикл while.
 * Буквы в каждой строке не разделять.
 * Пример вывода на экран:
 * SSSSSSSSSS
 * SSSSSSSSSS
 * SSSSSSSSSS
 * SSSSSSSSSS
 * SSSSSSSSSS
 * SSSSSSSSSS
 * SSSSSSSSSS
 * SSSSSSSSSS
 * SSSSSSSSSS
 * SSSSSSSSSS
 * <p>
 * <p>
 * Требования:
 * 1.	Программа не должна считывать текст c клавиатуры.
 * 2.	Программа должна выводить текст на экран.
 * 3.	Программа должна выводить квадрат из 10х10 букв S.
 * 4.	В программе должен использоваться цикл while.
 */

public class Task33 {
    public static void main(String[] args) {
        int chet2 = 10;
        do {
            int chet1 = 10;
            System.out.println();
            chet2--;
            do {
                System.out.print("S");
                chet1--;
            } while (chet1 > 0);
        }while (chet2 > 0);
    }
}
