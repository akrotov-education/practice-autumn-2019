package lesson02.cw.loop;

import java.time.LocalTime;

public class Do {

    public static void main(String[] args) {

        Integer secondWhile = 50;
        do {
            System.out.println();
        } while (secondWhile.equals(LocalTime.now().getSecond()));
    }
}
