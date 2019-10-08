package lesson01.part1;

public class Task04 {
    public static void main(String[] args) {

        int x = 27;
        int y = 15;

        y = x / y;
        x = x - y;
        y = y - x;

        System.out.println(Math.abs(x));
        System.out.println(Math.abs(y));
    }
}
