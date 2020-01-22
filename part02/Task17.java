package lesson05.part02;

/**
 * Лететь, бежать и плыть
 * Напиши public интерфейсы CanFly(летать), CanRun(бежать/ездить), CanSwim(плавать).
 * Добавить в каждый интерфейс по одному методу.
 * <p>
 * <p>
 * Требования:
 * 1. Класс Solution должен содержать интерфейс CanFly.
 * 2. Класс Solution должен содержать интерфейс CanRun.
 * 3. Класс Solution должен содержать интерфейс CanSwim.
 * 4. Интерфейс CanFly должен содержать один метод.
 * 5. Интерфейс CanRun должен содержать один метод.
 * 6. Интерфейс CanSwim должен содержать один метод.
 */

public class Task17 {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public int Fly();
    }

    public interface CanRun {
        public int Run();
    }

    public interface CanSwim {
        public int Swim();
    }

}
