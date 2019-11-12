package lesson01.part1;

public class Task11 {

    /**
     * Нужно посчитать, сколько литров воды нужно для заполнения бассейна до бортов.
     * Известно, что бассейн имеет линейные размеры a × b × c, заданные в метрах.
     * Эти размеры передаются в метод getVolume. Метод должен вернуть количество литров воды, которое нужно для наполнения бассейна.
     * <p>
     * Пример:
     * Метод getVolume вызывается с параметрами 25, 5, 2.
     * <p>
     * Пример вывода:
     * 250000
     * <p>
     * <p>
     * Требования:
     * 1. Метод getVolume(int, int, int) должен быть публичным и статическим.
     * 2. Метод getVolume(int, int, int) должен возвращать значение типа long.
     * 3. Метод getVolume(int, int, int) не должен ничего выводить на экран.
     * 4. Метод getVolume(int, int, int) должен правильно возвращать количество воды, которое необходимо для наполнения бассейна в литрах.
     */

    private static class Pool {
        final public int a = 25;
        final protected int b = 25;
        final private int c = 2;

        public static long getVolume(int a, int b, int c) {
            long volume = a * b * c * 1000;
            return volume;
        }

    }

    public static void main(String[] args) {
        Pool pool = new Pool();
        long poolVolume = pool.getVolume(25, 5, 2);
        System.out.println(poolVolume);
    }


}
