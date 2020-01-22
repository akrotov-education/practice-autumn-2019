package lesson05.part03;

/**
 * Параметризованый интерфейс
 * В классе StringObject реализуй интерфейс SimpleObject с параметром типа String.
 * <p>
 * <p>
 * Требования:
 * 1. Класс StringObject должен реализовывать интерфейс SimpleObject.
 * 2. Интерфейс SimpleObject в классе StringObject должен быть реализован с параметром типа String.
 * 3. В классе StringObject реализовать метод getInstance интерфейса SimpleObject.
 * 4. Дополнительные классы или интерфейсы создавать нельзя.
 */

public class Task07 {
    public static void main(String[] args) throws Exception {
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    class StringObject implements SimpleObject <String> //допишите здесь ваш код
    {
        @Override
        public SimpleObject getInstance() {
            return null;
        }
    }
}