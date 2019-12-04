package lesson02.part02;

/**
 * Напишите метод checkSeason. По номеру месяца, метод должен определить время года (зима, весна, лето, осень) и вывести на экран.
 * Пример для номера месяца 2:
 * зима
 * Пример для номера месяца 5:
 * весна
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна выводить текст на экран.
 * 2.	Метод main не должен вызывать функцию System.out.println или System.out.print.
 * 3.	Метод main должен вызывать метод checkSeason.
 * 4.	Метод checkSeason должен быть static void, и иметь только один параметр int.
 * 5.	Метод checkSeason должен выводить текст на экран согласно заданию.
 */

public class Task11 {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {
        //напишите тут ваш код
            if (month>2&month<6)
                System.out.println("Весна");
            else
                if (month>5&month<9)
                    System.out.println("Лето");
                else
                    if (month>8&month<12)
                        System.out.println("Осень");
                    else
                        if (month==12|| month>0&month<3)
                            System.out.println("Зима");
                        else
                            System.out.println("Ошибка! Число не является номером месяца.");

    }

    }
