package lesson04.part03;

/**
 * Перехватить исключение, возникающее при выполнении кода:
 * int a = 42 / 0;
 * Вывести на экран тип перехваченного исключения.
 *
 * Требования:
 * 1.	Программа должна выводить сообщение на экран.
 * 2.	В программе должен быть блок try-catch.
 * 3.	Программа должна отлавливать исключения конкретного типа, а не все возможные (Exception).
 * 4.	Выведенное сообщение должно содержать тип возникшего исключения.
 * 5.	Имеющийся код в методе main не удалять.
 *
 */

public class Task39 {

    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            int a = 42 / 0;
        } catch (ArithmeticException e){
            System.out.println("ArithmeticException: " + e);
        }

        //напишите тут ваш код
    }
}
