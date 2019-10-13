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
        //напишите тут ваш код
        String[] words = new String[3];
        words[0] = "Мама";
        words[1] = "Мыла";
        words[2] = "Раму";
        System.out.println(words[0] + words[1] + words[2]);
        System.out.println(words[0] + words[2] + words[1]);
        System.out.println(words[1] + words[0] + words[2]);
        System.out.println(words[1] + words[2] + words[0]);
        System.out.println(words[2] + words[0] + words[1]);
        System.out.println(words[2] + words[1] + words[0]);
    }
}
