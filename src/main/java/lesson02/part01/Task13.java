package lesson02.part01;

/**
 * Выведи на экран таблицу умножения 10 на 10 в следующем виде:
 * 1 2 3 4 …
 * 2 4 6 8 …
 * 3 6 9 12 …
 * 4 8 12 16 …
 * …
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна выводить текст.
 * 2.	Выведенный текст должен содержать 10 строк.
 * 3.	Каждая выведенная строка должна содержать 10 чисел, разделенных пробелом.
 * 4.	Выведенные числа должны быть таблицей умножения.
 */

public class Task13 {
    public static void main(String[] args) {
        //напишите тут ваш код
    for (int a=1; a<11;a++){
        for (int b=1; b<11;b++){
            System.out.print(b*a+" ");
        }
        System.out.println();
    }
    }
}
