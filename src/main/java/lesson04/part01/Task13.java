package lesson04.part01;

import java.util.ArrayList;

/**
 * 1. Создай список слов, заполни его самостоятельно.
 * 2. Метод fix должен:
 * 2.1. удалять из списка строк все слова, содержащие букву "р"
 * 2.2. удваивать все слова содержащие букву "л".
 * 2.3. если слово содержит и букву "р" и букву "л", то оставить это слово без изменений.
 * 2.4. с другими словами ничего не делать.
 *
 * Пример:
 * роза
 * лира
 * лоза
 *
 * Выходные данные:
 * лира
 * лоза
 * лоза
 *
 * Требования:
 * 1.	Программа не должна считывать данные с клавиатуры.
 * 2.	Метод fix должен удалять из списка строк все слова, содержащие букву "р".
 * Исключение: слова содержащие и букву "р" и букву "л" - их нужно оставить.
 * 3.	Метод fix должен удваивать слова, содержащие букву "л" (добавлять еще один элемент с этим словом).
 * Исключение: слова содержащие и букву "л" и букву "р" - их не нужно удваивать.
 * 4.	Метод fix не должен ничего делать со словами, содержащими и букву "л" и букву "р".
 * 5.	Метод fix не должен ничего делать со словами, которые не содержат ни букву "л", ни букву "р".
 */

public class Task13 {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<>();
    strings.add("роза");
    strings.add("лоза");
    strings.add("лира");
    strings.add("бром");
    strings.add("дедлайн");
    strings.add("москва");
    strings = fix(strings);

    for (String string : strings) {
      System.out.println(string);
    }
  }

  public static ArrayList<String> fix(ArrayList<String> strings) {
    //напишите тут ваш код
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.addAll(strings);
    for (String str:strings) {
      if(str.contains("р")){
        if(!str.contains("л")){
          arrayList.remove(str);
        }
      }else if(str.contains("л")){
        arrayList.add(arrayList.indexOf(str),str);
      }
    }
    return arrayList;
  }
}
