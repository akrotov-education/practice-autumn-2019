package lesson05.part03.task27;

import java.util.ArrayList;
import java.util.List;

/**
 * Репка
 * Сказка Репка:
 * 1. Реализовать интерфейс RepkaItem в классе Person.
 * 2. В классе Person реализовать метод pull(Person person), который выводит фразу типа '<name> за <person>'.
 * <p>
 * Пример:
 * Бабка за Дедку
 * Дедка за Репку
 * <p>
 * 3. Исправить логическую ошибку цикла в методе tell класса RepkaStory.
 * 4. Выполнить метод main и наслаждаться сказкой!
 * <p>
 * <p>
 * Требования:
 * 1. Интерфейс RepkaItem должен быть реализован в классе Person.
 * 2. В классе Person должен быть реализован метод pull c одним параметром типа Person.
 * 3. Метод pull в классе Person должен выводить на экран фразу типа '<name> за <person>'. Например: Бабка за Дедку.
 * 4. В результате выполнения метода main на экран должен быть выведен краткий вариант сказки про Репку.
 */

public class Task27 {
    public static void main(String[] args) {
        List<Person> plot = new ArrayList<Person>();
        plot.add(new Person("Репка", "Репку"));
        plot.add(new Person("Дедка", "Дедку"));
        plot.add(new Person("Бабка", "Бабку"));
        plot.add(new Person("Внучка", "Внучку"));
        RepkaStory.tell(plot);
    }
}
