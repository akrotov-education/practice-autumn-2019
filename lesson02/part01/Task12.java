package lesson02.part01;

/**
 * Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
 * Подсказка: их 6 штук. Каждую комбинацию вывести с новой строки. Слова не разделять. Пример:
 * МылаРамуМама
 * РамуМамаМыла
 * ...
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна выводить текст.
 * 2.	Выведенный текст должен содержать 6 строк.
 * 3.	Текст в каждой строке должен быть уникален.
 * 4.	Должны быть выведены все возможные комбинации.
 */

public class Task12 {
    public static void main(String[] args) {
        String a = "Мама";
        String b = "Мыла";
        String c = "Раму";

        String[] arr = {a, b, c};
        int count = fuctorial(arr.length);
        int max = arr.length - 1;
        int shift = max;
        String t;
        while (count > 0) {
            t = arr[shift];
            arr[shift] = arr[shift - 1];
            arr[shift - 1] = t;
            System.out.println(arr[0] + arr[1] + arr[2]);
            count--;
            if (shift < 2) {shift = max;}
            else {shift--;}
        }
    }

    static int fuctorial(int n) {
        return (n > 0) ? n * fuctorial(n - 1) : 1;
    }
}

