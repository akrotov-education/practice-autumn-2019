package lesson02.part02;

import java.util.Scanner;

/**
 * Ввести с клавиатуры четыре числа, и вывести максимальное из них. Если числа равны между собой, необходимо вывести любое.
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна считывать числа c клавиатуры.
 * 2.	Программа должна выводить число на экран.
 * 3.	Программа должна выводить на экран максимальное из четырёх чисел.
 * 4.	Если максимальных чисел несколько, необходимо вывести любое из них.
 */

public class Task19 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int x, y, z;
        Maxf maxf = new Maxf();
        System.out.println("Введите четыре целых числа: ");
        maxf.a = sc.nextInt();
        maxf.b = sc.nextInt();
        maxf.c = sc.nextInt();
        maxf.d = sc.nextInt();
        maxf.max4(maxf.a, maxf.b, maxf.c, maxf.d);
    }

    public static class Maxf {
        public int a, b, c, d;

        public int max2(int a, int b) {
            this.a = a;
            this.b = b;
            int max2;
            if (a > b) {
                max2 = a;
            } else {
                max2 = b;
            }
            return max2;
        }

        public void max4(int a, int b, int c, int d) {
            this.a = a; this.b = b; this.c = c; this.d = d;
            int res;
            int t = max2(a, b);
            if(t>c && t>d){res=t;
                System.out.println(res);
            }
            else if(c>t && c>d){res=c;
                System.out.println(res);}
            else {res=d;
            System.out.println(res);}
        }
    }
}

