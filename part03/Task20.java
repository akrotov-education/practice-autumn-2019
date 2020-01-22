package lesson05.part03;

/**
 * Neo
 * 1. Реализовать интерфейс DBObject в классе User.
 * 2. Реализовать метод initializeIdAndName так, чтобы программа работала и выводила на экран "The user's name is Neo, id = 1".
 * 3. Метод toString и метод main менять нельзя.
 * 4. Подумай, что должен возвращать метод initializeIdAndName в классе User.
 * <p>
 * <p>
 * Требования:
 * 1. Интерфейс DBObject должен быть реализован в классе User.
 * 2. Метод initializeIdAndName должен возвращать корректный объект типа User, объект на котором производится вызов метода("этот" объект).
 * 3. Метод initializeIdAndName должен устанавливать значения полей id и name согласно переданным ему параметрам.
 * 4. Программа должна выводить на экран: "The user's name is Neo, id = 1"
 * 5. Метод toString не менять.
 * 6. Метод main не менять.
 */

public class Task20 {

    public static void main(String[] args) throws Exception {
        System.out.println(Matrix.NEO);
    }

    static class Matrix {
        public static DBObject NEO = new User().initializeIdAndName(1, "Neo");
    }

    interface DBObject {
        DBObject initializeIdAndName(long id, String name);
    }

    static class User implements DBObject {
        long id;
        String name;

        @Override
        public String toString() {
            return String.format("The user's name is %s, id = %d", name, id);
        }

        @Override
        public DBObject initializeIdAndName(long id, String name) {
            this.id=id; this.name = name;
            return this;
        }
    }

}
