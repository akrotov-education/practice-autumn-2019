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
    public static Map<Double, String> labels;
    static {
        labels = new HashMap<Double, String>();
        labels.put(1d,"1");
        labels.put(2d,"2");
        labels.put(3d,"3");
        labels.put(4d,"4");
        labels.put(5d,"5");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
