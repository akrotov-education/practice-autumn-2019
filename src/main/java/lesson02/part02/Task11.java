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
        switch (month){
            case (1):
                System.out.println("Январь - Зима");
                break;
            case (2):
                System.out.println("Февраль - Зима");
                break;
            case (3):
                System.out.println("Март - Весна");
                break;
            case (4):
                System.out.println("Апрель - Весна");
                break;
            case (5):
                System.out.println("Май - Весна");
                break;
            case (6):
                System.out.println("Июнь - Лето");
                break;
            case (7):
                System.out.println("Июль - Лето");
                break;
            case (8):
                System.out.println("Август - Лето");
                break;
            case (9):
                System.out.println("Сентябрь - Осень");
                break;
            case (10):
                System.out.println("Октябрь - Осень");
                break;
            case (11):
                System.out.println("Ноябрь - Осень");
                break;
            case (12):
                System.out.println("Декабрь - Зима");
                break;
            default:
                System.out.println("Нет такого месяца");
                break;
        }

    }
}