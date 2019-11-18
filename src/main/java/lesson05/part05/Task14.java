package lesson05.part05;

import java.util.HashMap;
import java.util.Map;

/**
 * Статики-1
 * В статическом блоке инициализировать labels 5 различными парами ключ-значение.
 * <p>
 * <p>
 * Требования:
 * 1. В классе Solution должен быть только один метод (main).
 * 2. В классе Solution должно быть объявлено статическое поле labels типа Map.
 * 3. Поле labels должно быть заполнено 5 различными парами ключ-значение в статическом блоке.
 * 4. Метод main должен выводить содержимое labels на экран.
 */

public class Task14 {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
