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
        String str1 = "Мама" , str2 = "Мыла" , str3 = "Раму";
        System.out.println(str1+str2+str3);
        System.out.println(str1+str3+str2);
        System.out.println(str2+str1+str3);
        System.out.println(str2+str3+str1);
        System.out.println(str3+str1+str2);
        System.out.println(str3+str2+str1);
    }
}
