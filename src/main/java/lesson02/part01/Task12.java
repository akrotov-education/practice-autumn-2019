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
    static String[] mass = {"Мама", "Мыла", "Раму"};

    public static void Swap(int a, int b) {
        String t = mass[a];
        mass[a] = mass[b];
        mass[b] = t;
    }

    public static void Generate(int k) {
        if (k == 2) {
            for (int i = 0; i < 3; i++) {
                System.out.print(mass[i]);
            }
            System.out.println(" ");
        } else {
            for (int j = k; j < 3; j++) {
                Swap(k, j);
                Generate(k + 1);
                Swap(k, j);
            }
        }
    }

    public static void main(String[] args) {
        Generate(0);
    }
}