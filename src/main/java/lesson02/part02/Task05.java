package main.java.lesson02.part02;

/**
 * Напишите метод setCatsCount. Метод должен устанавливать количество котов (catsCount).
 * <p>
 * <p>
 * Требования:
 * 1.	Класс Cat должен содержать только одну переменную catsCount.
 * 2.	Переменная catsCount должна быть статической, иметь модификатор доступа private, тип int и проинициализирована нулем.
 * 3.	Класс Cat должен содержать два метода setCatsCount и main.
 * 4.	Метод setCatsCount класса Cat должен устанавливать значение переменной catsCount равным переданному параметру.
 */

public class Task05 {

    public static void main(String[] args) {
        Cat cats = new Cat();
        cats.setCatsCount(5);
        System.out.println(cats.catsCount);
        cats.setCatsCount(10);
        System.out.println(cats.catsCount);
    }

    public static class Cat {
        private static int catsCount = 0;

        public void setCatsCount(int catsCount) {
            //напишите тут ваш код
            this.catsCount = catsCount;


        }
    }
}
