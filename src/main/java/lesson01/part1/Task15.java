package lesson01.part1;

public class Task15 {

    /**
     * Выводим квадрат числа
     * Дана переменная number.
     * Напиши программу, которая выводит на экран квадрат этой переменной (number * number).
     * <p>
     * <p>
     * Требования:
     * 1. У переменной number можно менять только значение.
     * 2. Программа должна выводить текст.
     * 3. Выводимый текст должен быть числом.
     * 4. Выводимый текст должен быть квадратом переменной number.
     * 5. Вы слышали что-нибудь о классе Math?
     */

    public static int number = 25;

    public static void main(String[] args) {
        System.out.println(Math.pow(number, 2));
    }
}
