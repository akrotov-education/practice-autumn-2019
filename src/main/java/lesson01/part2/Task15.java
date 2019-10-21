package lesson01.part2;

public class Task15 {

    /**
     * О семейных отношениях
     * В методе main создай объект Man, сохрани ссылку на него в переменную man.
     * Создай также объект Woman и сохрани ссылку на него в переменную woman.
     * <p>
     * Подсказка: для создания объекта Woman и занесения его ссылки в переменную woman используй конструкцию:
     * Тип Переменной имяПеременной = new ТипСоздаваемогоОбъекта();
     * В man.wife сохрани ссылку на ранее созданный объект Woman.
     * В woman.husband сохрани ссылку на ранее созданный объект Man (подсказка: woman.husband = man;).
     * <p>
     * <p>
     * Требования:
     * 1. В методе main создай объект Man и сразу сохрани ссылку на него в переменную man.
     * 2. В методе main создай объект Woman и сразу сохрани ссылку на него в переменную woman.
     * 3. В методе main сохрани ссылку на ранее созданный объект Woman в man.wife.
     * 4. В методе main сохрани ссылку на ранее созданный объект Man в woman.husband.
     * 5. Класс Man должен содержать 3 переменные
     * 6. Класс Woman должен содержать 3 переменные
     */

    public static void main(String[] args) {
        //напишите тут ваш код
    }

    public static class Man {
        public int age;
        public int height;
        public Woman wife;
    }

    public static class Woman {
        public int age;
        public int height;
        public Man husband;
    }
}
