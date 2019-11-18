package lesson05.part03;

/**
 * Интерфейс Updatable в классе Screen
 * Реализовать интерфейс Updatable в классе Screen.
 * <p>
 * <p>
 * Требования:
 * 1. Интерфейс Updatable должен наследовать(extends) интерфейс Selectable.
 * 2. Класс Screen должен реализовывать(implements) интерфейс Updatable.
 * 3. В классе Screen должен быть реализован метод onSelect интерфейса Selectable.
 * 4. В классе Screen должен быть реализован метод refresh интерфейса Updatable.
 */

public class Task23 {
    public static void main(String[] args) throws Exception {
    }

    interface Selectable {
        void onSelect();
    }

    interface Updatable extends Selectable {
        void refresh();
    }

    class Screen {

    }
}
