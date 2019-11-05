package lesson04.part03;

/**
 * Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
 * int[] m = new int[2];
 * m[8] = 5;
 *
 * Требования:
 * 1.	Программа должна выводить сообщение на экран.
 * 2.	В программе должен быть блок try-catch.
 * 3.	Программа должна отлавливать исключения конкретного типа, а не все возможные (Exception).
 * 4.	Выведенное сообщение должно содержать тип возникшего исключения.
 * 5.	Имеющийся код в методе main не удалять.
 */

public class Task41 {

  public static void main(String[] args) {
    //напишите тут ваш код
    int[] m = new int[2];
    try{
      m[8] = 5;
    }catch (ArrayIndexOutOfBoundsException e){
      e.printStackTrace();
      System.out.println(e.getClass().getName());
    }
    //напишите тут ваш код
  }
}
