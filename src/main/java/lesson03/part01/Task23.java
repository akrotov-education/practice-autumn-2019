package lesson03.part01;

/**
 * В классе Cat создай статическую переменную public int catCount.
 * Создай конструктор [public Cat()]. Пусть при каждом создании кота (нового объекта Cat)
 * статическая переменная catCount увеличивается на 1. Создать 10 объектов Cat и
 * вывести значение переменной catCount на экран.
 * <p>
 * Требования:
 * 1.	В классе Cat создай статическую переменную public int catCount.
 * 2.	В классе Cat создай конструктор public Cat() без параметров.
 * 3.	Конструктор должен увеличивать значение статической переменной catCount на 1.
 * 4.	В методе main создай 10 котов.
 * 5.	В методе main, после создания всех котов, выведи значение переменной catCount.
 */

public class Task23 {

  public static void main(String[] args) {
    Cat Barsuk = new Cat();
    Cat Edjik = new Cat();
    Cat Krotik = new Cat();
    Cat Bilka = new Cat();
    Cat Lacalut = new Cat();
    Cat Shakalat = new Cat();
    Cat Olya = new Cat();
    Cat DjSlovik = new Cat();
    Cat Beliy = new Cat();
    Cat Cherniy = new Cat();

    System.out.println(Barsuk.catCount);
  }

  public static class Cat {
    public static int catCount;
    public Cat(){
      this.catCount=catCount+1;
    }
  }
}