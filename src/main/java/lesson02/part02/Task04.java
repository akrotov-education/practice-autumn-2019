package lesson02.part02;

/**
 * Напиши код в методе addNewCat, чтобы при его вызове количество котов увеличивалось на 1.
 * За количество котов отвечает переменная catsCount.
 * <p>
 * <p>
 * Требования:
 * 1.	Класс Cat должен содержать только одну переменную catsCount.
 * 2.	Переменная catsCount должна быть статической, иметь модификатор доступа private, тип int и проинициализирована нулем.
 * 3.	Класс Cat должен содержать два метода addNewCat и main.
 * 4.	Метод addNewCat класса Cat должен увеличивать количество котов на 1.
 */

public class Task04 {

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.addNewCat();
        Cat cat2 = new Cat();
        cat2.addNewCat();
        Cat cat3 = new Cat();
        cat3.addNewCat();
        System.out.println("Всего котиков: " + cat1.catsCount);
    }

    public static class Cat {
        private static int catsCount = 0;

        public static void addNewCat() {
            catsCount++;
        }
    }

}

