package lesson05.part03;

/**
 * Selectable и Updatable
 * Создай класс Screen и реализуй в нем интерфейсы Selectable и Updatable.
 * Не забудь реализовать методы!
 * <p>
 * <p>
 * Требования:
 * 1. Класс Screen должен реализовывать(implements) интерфейс Selectable.
 * 2. Класс Screen должен реализовывать(implements) интерфейс Updatable.
 * 3. В классе Screen должен быть реализованы методы интерфейса Selectable.
 * 4. В классе Screen должен быть реализованы методы интерфейса Updatable.
 */

public class Task04 {
    public static void main(String[] args) throws Exception {
    }

    interface Selectable {
        void onSelect();
    }

    interface Updatable {
        void refresh();
    }

    //напишите тут ваш класс
}
