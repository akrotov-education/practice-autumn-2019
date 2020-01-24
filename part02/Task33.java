package lesson05.part02;

/**
 * Изоморфы наступают
 * Написать метод, который возвращает минимальное число в массиве и его позицию (индекс).
 * <p>
 * <p>
 * Требования:
 * 1. Класс Solution должен содержать класс Pair.
 * 2. Класс Solution должен содержать два метода.
 * 3. Класс Solution должен содержать метод getMinimumAndIndex().
 * 4. Метод getMinimumAndIndex() должен возвращать минимальное число в массиве и его позицию (индекс).
 */

public class Task33 {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The index of the minimum element is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
        Pair<Integer, Integer> min = new Pair<>(array[0], 0);
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min.x) {
                min.x = array[i];
                min.y = i;
            }
        }
        return min;
    }


    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
