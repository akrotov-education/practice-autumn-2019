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
    	String[] str = {"Мама", "Мыла", "Раму"};
    	for (String string : str) {
    		String endStr = string;
			for (int i = 0; i < str.length; i++) {
				if(!string.contentEquals(str[i])) {
					endStr += str[i];
				}
			}
			System.out.println(endStr);
			endStr = string;
			for (int i = str.length - 1; i >= 0; i--) {
				if(!string.contentEquals(str[i])) {
					endStr += str[i];
				}
			}
			System.out.println(endStr);
		}
    }
}
