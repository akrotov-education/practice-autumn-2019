package lesson02.part01;

/**
 * Экранирование символов
 * <p>
 * Вывести на экран следующий текст - две строки:
 * <p>
 * It's Windows path: "C:\Program Files\Java\jdk1.7.0\bin"
 * It's Java string: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\"
 * Подсказка:
 * \” – экранирование двойной кавычки;
 * \\ – экранирование обратной косой черты (\).
 * Больше про экранирование символов и Escape-последовательности в Java читай в статье:
 * https://javarush.ru/groups/posts/614-----ehkranirovanie-simvolov-v-java
 * <p>
 * <p>
 * Требования:
 * 1.	Программа должна выводить текст.
 * 2.	Должно быть выведено две строки.
 * 3.	Текст первый строки должен быть: It's Windows path: "C:\Program Files\Java\jdk1.7.0\bin"
 * 4.	Текст второй строки должен быть: It's Java string: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\"
 */

public class Task15 {
    public static void main(String[] args) {
        System.out.println("It\'s Windows path:\"C:\\Program Files\\Java\\jdk1.7.0\\bin\'");
        System.out.println("It\'s Java string: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\'");
    }
}
