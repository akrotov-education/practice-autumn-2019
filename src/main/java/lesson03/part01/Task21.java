package lesson03.part01;

/**
 * Добавить к классу Cat два статических метода: int getCatCount() и setCatCount(int),
 * с помощью которых можно получить/изменить количество котов (переменную catCount).
 * <p>
 * Требования:
 * 1.	Добавь в класс метод getCatCount.
 * 2.	Метод getCatCount должен возвращать int.
 * 3.	Метод getCatCount должен возвращать значение переменной catCount.
 * 4.	Добавь в класс метод setCatCount, принимающий int.
 * 5.	Метод setCatCount ничего не должен возвращать.
 * 6.	Метод setCatCount должен присваивать переменной catCount переданное значение.
 */

public class Task21 {

  public static void main(String[] args) {

  }

  public static class Cat {

    private static int catCount = 0;

    public Cat() {
      catCount++;
    }

    public static int getCatCount() {
      return catCount;
    }

    public static void setCatCount(int catCount) {
      Cat.catCount = catCount;
    }
  }
}