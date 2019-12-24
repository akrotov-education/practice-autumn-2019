package lesson03.part01;

/**
 * Разберись, что делает программа.
 * Найди и исправь одну ошибку в классе Circle. Метод main изменять нельзя.
 * <p>
 * Подсказка:
 * изучи конструктор по умолчанию.
 * <p>
 * Требования:
 * 1.	Программа не должна считывать данные с клавиатуры.
 * 2.	Метод main изменять нельзя.
 * 3.	Программа должна вывести слово "Red" на экран.
 * 4.	Метод getDescription класса Color должен возвращать значение переменной description.
 * 5.	Метод setDescription класса Color должен устанавливать значение переменной description.
 */

public class Task16 {

  public static void main(String[] args) {
    Circle circle = new Circle();
    circle.color.setDescription("Red");
    System.out.println(circle.color.getDescription());
  }

  public static class Circle {

    public Color color;

    public Circle() {
      color = new Color();
    }

    public class Color {

      String description;

      public String getDescription() {
        return description;
      }

      public void setDescription(String description) {
        this.description = description;
      }
    }
  }
}