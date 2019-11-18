package lesson05.part05;

/**
 * Порядок загрузки переменных
 * Разберись, что и в какой последовательности инициализируется. Поставь брейкпойнты и используй дебаггер.
 * <p>
 * Исправить порядок инициализации данных так, чтобы результат был следующим:
 * static void init()
 * Static block
 * public static void main
 * Non-static block
 * static void printAllFields
 * 0
 * null
 * Solution constructor
 * static void printAllFields
 * 6
 * First name
 * <p>
 * <p>
 * Требования:
 * 1. Программа должна выводить данные на экран.
 * 2. Вывод на экран должен соответствовать условию задачи.
 * 3. Результатом работы статического инициализатора класса Solution должен быть вывод на экран строк "static void init()" и "Static block".
 * 4. Программа не должна считывать данные с клавиатуры.
 */

public class Task24 {
    static {
        System.out.println("Static block");
    }

    {
        System.out.println("Non-static block");
        printAllFields(this);
    }

    public int i = 6;

    public String name = "First name";

    static {
        init();
    }

    public Task24() {
        System.out.println("Solution constructor");
        printAllFields(this);
    }

    public static void init() {
        System.out.println("static void init()");
    }

    public static void main(String[] args) {
        System.out.println("public static void main");
        Task24 s = new Task24();
    }

    public static void printAllFields(Task24 obj) {
        System.out.println("static void printAllFields");
        System.out.println(obj.name);
        System.out.println(obj.i);
    }
}
