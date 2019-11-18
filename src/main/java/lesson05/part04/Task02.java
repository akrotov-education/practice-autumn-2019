package lesson05.part04;

/**
 * Building и School
 * 1. Расставь правильно наследование между Building(здание) и School(здание школы).
 * 2. Подумай, объект какого класса должен возвращать методы getSchool и getBuilding.
 * 3. Измени null на объект класса Building или School.
 * <p>
 * <p>
 * Требования:
 * 1. Класс School должен наследоваться от класса Building.
 * 2. Метод getSchool должен возвращать новую школу(School).
 * 3. Метод getBuilding должен возвращать новое здание(Building).
 * 4. Класс School должен быть статическим.
 * 5. Класс Building должен быть статическим.
 */

public class Task02 {
    public static void main(String[] args) {
        Building school = getSchool();
        Building shop = getBuilding();

        System.out.println(school);
        System.out.println(shop);
    }

    public static Building getSchool() {
        //измените null на объект класса Building или School
        return null;
    }

    public static Building getBuilding() {
        //измените null на объект класса Building или School
        return null;
    }

    static class School /*Добавьте сюда ваш код*/ {
        @Override
        public String toString() {
            return "School";
        }
    }

    static class Building /*Добавьте сюда ваш код*/ {
        @Override
        public String toString() {
            return "Building";
        }
    }
}
