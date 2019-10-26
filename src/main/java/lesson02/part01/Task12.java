package lesson02.part01;
import java.util.ArrayList;
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
        ArrayList<String> array = new ArrayList<String>();
        array.add("Мама");
        array.add("Мыла");
        array.add("Раму");
        for(int i=0; i<array.size(); i++){
            System.out.println(slova(array,i).trim());
        }
    }
    public static String slova (ArrayList<String> array, int index){
        String result = "";
        for(int i=0; i<array.size()-1; i++) {
            result+=array.get(index);
            ArrayList<String> temp = new ArrayList<>(array);
            temp.remove(array.get(index));
            result+=slova(temp,i);
        }
        if(array.size()==1)
            result+=array.get(0)+"\n";
        return result;
    }
}
