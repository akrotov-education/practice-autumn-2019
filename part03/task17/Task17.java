package lesson05.part03.task17;

/**
 * The weather is fine
 * 1. В классе Today реализовать интерфейс Weather.
 * 2. Подумай, как связан параметр type с методом getWeatherType().
 * 3. Интерфейсы Weather и WeatherType уже реализованы в отдельных файлах.
 * <p>
 * <p>
 * Требования:
 * 1. Интерфейс Weather должен быть реализован в классе Today.
 * 2. В классе Today должен быть реализован метод getWeatherType объявленный в интерфейсе Weather.
 * 3. Тип возвращаемого значения метода getWeatherType должен быть String.
 * 4. Метод getWeatherType должен возвращать значение переменной type.
 */

public class Task17 {

    public static void main(String[] args) {
        System.out.println(new Today(lesson05.part03.task17.WeatherType.CLOUDY));
        System.out.println(new Today(lesson05.part03.task17.WeatherType.FOGGY));
        System.out.println(new Today(lesson05.part03.task17.WeatherType.FREEZING));
    }

    static class Today implements lesson05.part03.task17.Weather {
        private String type;

        @Override
        public String getWeatherType() {
            return this.type;
        }

        Today(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format("Today it will be %s", this.getWeatherType());
        }
    }

}
