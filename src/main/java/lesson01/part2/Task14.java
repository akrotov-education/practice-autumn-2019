package lesson01.part2;

public class Task14 {

    /**
     * Реализуй метод print3. Метод должен вывести переданную строку (слово) на экран три раза через пробел.
     * <p>
     * <p>
     * Требования:
     * 1. Программа должна выводить текст на экран.
     * 2. Метод main не должен вызывать функцию System.out.println или System.out.print.
     * 3. Метод print3 должен выводить текст на экран.
     * 4. Метод main должен вызвать метод print3 ровно два раза.
     * 5. Метод print3 должен выводить переданную строку (слово) на экран три раза, но в одной строке.
     */

    public static void print3(String s) {
        System.out.print(s + " " + s + " " + s);

    }

    public static void main(String[] args) {
        print3("window");
        print3("file");
    }
}
