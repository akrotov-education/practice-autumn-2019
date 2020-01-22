package lesson05.part05;

/**
 * Значения по умолчанию
 * 1. Создать 7 public полей класса. Убедитесь, что они инициализируются дефолтными значениями.
 * intVar типа int
 * doubleVar типа double
 * DoubleVar типа Double
 * booleanVar типа boolean
 * ObjectVar типа Object
 * ExceptionVar типа Exception
 * StringVar типа String
 * 2. В методе main вывести их значения в заданном порядке.
 * <p>
 * <p>
 * Требования:
 * 1. В классе Solution должно быть объявлено поле intVar типа int.
 * 2. В классе Solution должно быть объявлено поле doubleVar типа double.
 * 3. В классе Solution должно быть объявлено поле DoubleVar типа Double.
 * 4. В классе Solution должно быть объявлено поле booleanVar типа boolean.
 * 5. В классе Solution должно быть объявлено поле ObjectVar типа Object.
 * 6. В классе Solution должно быть объявлено поле ExceptionVar типа Exception.
 * 7. В классе Solution должно быть объявлено поле StringVar типа String.
 * 8. Метод main должен выводить значения полей на экран(каждое с новой строки или через пробел) в заданном порядке. Инициализировать переменные не нужно.
 */

public class Task16 {
    public static int intVar;
    public static double doubleVar;
    public static Double DoubleVar;
    public static boolean booleanVar;
    public static Object ObjectVar;
    public static Exception ExceptionVar;
    public static String StringVar;

    public static void main(String[] args) {
        System.out.println(intVar);
        System.out.println(doubleVar);
        System.out.println(DoubleVar);
        System.out.println(booleanVar);
        System.out.println(ObjectVar);
        System.out.println(ExceptionVar);
        System.out.println(StringVar);
    }
}
