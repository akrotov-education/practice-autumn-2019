package lesson05.part03;

import java.awt.*;

/**
 * Лисица — это такое животное
 * 1. Реализуй в классе Fox интерфейс Animal.
 * 2. Поменяй код так, чтобы в классе Fox был только один метод - getName.
 * 3. Создавать дополнительные классы и удалять методы нельзя!
 * <p>
 * <p>
 * Требования:
 * 1. Интерфейс Animal должен быть реализован в классе Fox.
 * 2. В классе Fox должен быть реализован только один метод(getName).
 * 3. В интерфейсе Animal должен быть объявлен метод getColor.
 * 4. Дополнительные классы или интерфейсы создавать нельзя.
 */

public class Task13 {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        Color getColor();
    }

    public abstract static class Fox implements Animal {
        public String getName() {
            return "Fox";
        }

    }
}