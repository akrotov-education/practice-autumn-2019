package lesson01.part1;

public class Task07 {

    /**
     * Метод convertCelsiusToFahrenheit(int celsius) принимает значение в градусах Цельсия. Метод должен переводить температуру и возвращать значение в градусах Фаренгейта.
     * Температура по Цельсию TC и температура по Фаренгейту TF связаны следующим соотношением:
     * TF = (9 / 5) * TC + 32
     * <p>
     * Пример:
     * В метод convertCelsiusToFahrenheit на вход подается значение 41.
     * <p>
     * Пример вывода:
     * 105.8
     * <p>
     * <p>
     * Требования:
     * 1. Метод convertCelsiusToFahrenheit(int) должен быть публичным и статическим.
     * 2. Метод convertCelsiusToFahrenheit должен возвращать значение типа double.
     * 3. Метод convertCelsiusToFahrenheit не должен ничего выводить на экран.
     * 4. Метод convertCelsiusToFahrenheit должен правильно переводить градусы Цельсия в градусы Фаренгейта и возвращать это число.
     */

    public static void main(String[] args) {
        System.out.println(convertCelsiusToFahrenheit(41));
    }

    public static double convertCelsiusToFahrenheit(int celsius) {
        double TF = (9.0/5.0) * celsius+32;
        return TF;
    }
}