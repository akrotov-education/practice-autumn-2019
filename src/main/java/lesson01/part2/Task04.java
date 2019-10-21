package lesson01.part2;

import com.sun.org.apache.bcel.internal.classfile.LocalVariableTable;

public class Task04 {

    /**
     * В методе main объяви две переменные a и b типа int.
     * Присвой им любые значения.
     * Выведи на экран их сумму и произведение.
     * Каждое значение выводить с новой строки.
     * <p>
     * Пример вывода на экран для а = 5, b = 7:
     * 12
     * 35
     * <p>
     * <p>
     * Требования:
     * 1. Программа должна выводить текст на экран.
     * 2. В программе должны быть только две переменные: a и b типа int.
     * 3. Переменным сразу должны быть присвоены значения.
     * 4. Метод main должен выводить на экран сумму переменных a и b.
     * 5. Метод main должен выводить на экран произведение переменных a и b.
     * 6. Каждое значение должно быть выведено с новой строки
     */
    public int a = 10;
    public int b = 20;


    public static Task04 obj;


    public static void main(String[] args) {
        obj = new Task04();

        System.out.println(obj.a+obj.b);
        System.out.println(obj.a*obj.b);
    }

}
