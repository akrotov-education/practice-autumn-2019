package lesson01.part2;

public class Task09 {

    /**
     * Создай объект типа Cat (кот), объект типа Dog (собака), объект типа Fish (рыбка) и объект типа Woman.
     * Присвой каждому животному владельца (owner).
     * <p>
     * <p>
     * Требования:
     * 1. Программа не должна выводить текст на экран.
     * 2. В методе main создай объекты типа Cat, Dog, Fish, Woman занеси их ссылки в переменные.
     * 3. В методе main присвойте каждому животному владельца Woman.
     * 4. Класс Cat, Dog, Fish должен содержать только одну переменную Woman owner.
     * 5. Класс Woman не должен содержать переменных.
     */

    public static void main(String[] args) {
        Woman woman=new Woman();
        Cat cat=new Cat();
        cat.owner=woman;
        Fish cat1=new Fish();
        cat1.owner=woman;
        Dog cat2=new Dog();
        cat2.owner=woman;

    }

    public static class Cat {
        public Woman owner;
    }

    public static class Dog {
        public Woman owner;
    }

    public static class Fish {
        public Woman owner;
    }

    public static class Woman {
    }
}
