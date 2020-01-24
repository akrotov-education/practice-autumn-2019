package lesson05.part03;

/**
 * 1. Подумай, какой из двух интерфейсов нужно реализовать в классе BeerLover.
 * 2. Добавь к классу BeerLover этот интерфейс и реализуй все его методы.
 * 3. Подумай, как связаны переменная READY_TO_GO_HOME и метод isReadyToGoHome.
 * 4. Верни значение переменной READY_TO_GO_HOME в методе isReadyToGoHome.
 * <p>
 * <p>
 * Требования:
 * 1. Класс BeerLover должен реализовывать(implements) интерфейс Alcoholic.
 * 2. Класс BeerLover не должен реализовывать интерфейс Drinker напрямую(только опосредованно через Alcoholic)
 * 3. В классе BeerLover должны быть реализованы все методы интерфейса Alcoholic.
 * 4. В классе BeerLover должны быть реализованы все методы интерфейса Drinker.
 * 5. Метод isReadyToGoHome должен возвращать значение переменной READY_TO_GO_HOME.
 */
public class Task01 {
    public static void main(String[] args) throws Exception {
    }

    public interface Drinker {
        void askForMore(String message);
        void sayThankYou();
        boolean isReadyToGoHome();
    }

    public interface Alcoholic extends Drinker {
        boolean READY_TO_GO_HOME = false;
        void sleepOnTheFloor();
    }

    public static class BeerLover implements Alcoholic {
        @Override
        public void sleepOnTheFloor() {
        }
        @Override
        public void askForMore(String message) {
        }
        @Override
        public void sayThankYou() {
        }
        @Override
        public boolean isReadyToGoHome() {
            return false;
        }
    }
}