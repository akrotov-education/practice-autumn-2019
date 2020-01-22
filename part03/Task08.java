package lesson05.part03;

/**
 * Эй, ты там живой?
 * 1. Создай интерфейс Person.
 * 2. Добавь в него метод isAlive(), который проверяет, жив человек или нет.
 * 3. Подумай, какой тип должен возвращать этот метод.
 * 4. Создай интерфейс Presentable.
 * 5. Унаследуй интерфейс Presentable от интерфейса Person.
 * <p>
 * <p>
 * Требования:
 * 1. В классе Solution должен быть объявлен интерфейс Person.
 * 2. В классе Solution должен быть объявлен интерфейс Presentable.
 * 3. Интерфейс Presentable должен наследоваться от интерфейса Person.
 * 4. В интерфейсе Person должен быть объявлен метод isAlive.
 * 5. Тип возвращаемого значения метода isAlive может иметь только два значения.
 */

public class Task08 {
    public static void main(String[] args) throws Exception {
    }

    interface Person{
        public boolean isAlive();
    }

    interface Presentable extends Person{

    }
}