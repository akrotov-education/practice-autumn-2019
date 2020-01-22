package lesson05.part03;

/**
 * Это кто там такой умный?
 * 1. Добавь интерфейсы Secretary и Boss к классам CleverMan и SmartGirl. По одному на каждый. Подумай, кому какой.
 * 2. Унаследуй интерфейсы Secretary и Boss от интерфейсов Person и Workable так,
 * чтобы все методы у классов CleverMan и SmartGirl оказались объявленными в каком-то интерфейсе.
 * <p>
 * <p>
 * Требования:
 * 1. Класс CleverMan должен реализовывать подходящий ему интерфейс(Secretary или Boss).
 * 2. Класс SmartGirl должен реализовывать подходящий ему интерфейс(Secretary или Boss).
 * 3. Секретарь(Secretary) является человеком(Person).
 * 4. Начальник(Boss) является человеком(Person), а также любит много работать(Workable).
 */

public class Task10 {
    public static void main(String[] args) throws Exception {
    }

    interface Person {
        void use(Person person);

        void startToWork();
    }

    interface Workable {
        boolean wantsToGetExtraWork();
    }

    interface Secretary extends Person {
    }

    interface Boss extends Person,Workable {
    }

    class CleverMan implements Boss {
        public void use(Person person) {
            person.startToWork();
        }

        public void startToWork() {
        }

        public boolean wantsToGetExtraWork() {
            return true;
        }
    }

    class SmartGirl implements Secretary{
        public void use(Person person) {
        }

        public void startToWork() {
        }
    }
}
