package lesson05.part03;

import java.awt.*;

/**
 * Один метод в классе
 * 1. Унаследовать Fox от интерфейса Animal.
 * 2. Поменяй код так, чтобы в классе Fox был только один метод - getName.
 * 3. Методы удалять нельзя!
 * <p>
 * <p>
 * Требования:
 * 1. Интерфейс Animal должен быть реализован в классе Fox.
 * 2. В классе Fox должен быть реализован только один метод(getName).
 * 3. В интерфейсе Animal должен быть объявлен метод getColor.
 * 4. Дополнительные классы или интерфейсы создавать нельзя.
 */

public class Task24 {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        Color getColor();

        Integer getAge();
    }

    public static class Fox {
        public String getName() {
            return "Fox";
        }
    }
}
