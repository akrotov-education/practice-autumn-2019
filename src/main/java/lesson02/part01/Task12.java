package lesson02.part01;

import org.omg.CORBA.WStringSeqHelper;

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
        String[] strArray = { "Мама", "Мыла", "Раму" };

        for (int i = 0; i < strArray.length; i++) {
            String currentCombination = strArray[i];
            for (int j = 0; j < strArray.length; j++) {
                if (j == i) continue;

                currentCombination += strArray[j];
            }

            System.out.println(currentCombination);
        }
    }
}
