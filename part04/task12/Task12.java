package lesson05.part04.task12;
import  lesson05.part04.task12.Computer;
import lesson05.part04.task12.Keyboard;
import lesson05.part04.task12.Mouse;
import lesson05.part04.task12.Monitor;
import lesson05.part04.task12.CompItem;

/**
 * Computer
 * 1. Создай интерфейс CompItem.
 * 2. Добавь в него метод String getName().
 * 3. Создай классы Keyboard, Mouse, Monitor, которые реализуют интерфейс CompItem.
 * 4. Метод getName() должен возвращать имя класса, например, для класса Keyboard будет "Keyboard".
 * 5. Создай класс Computer.
 * 6. В класс Computer добавь приватное поле keyboard типа Keyboard.
 * 7. В класс Computer добавь приватное поле mouse типа Mouse.
 * 8. В класс Computer добавь приватное поле monitor типа Monitor.
 * 9. Создай конструктор с тремя параметрами в классе Computer используя комбинацию клавиш Alt+Insert внутри класса (команда Constructor).
 * 10. Внутри конструктора инициализируйте все три поля (переменных) класса в соответствии с переданными параметрами.
 * 11. Создай геттеры для полей класса Computer (в классе используй комбинацию клавиш Alt+Insert и выбери команду Getter).
 * 12. Все созданные классы и интерфейс должны быть в отдельных файлах.
 * <p>
 * <p>
 * Требования:
 * 1. Интерфейс CompItem должен существовать в отдельном файле.
 * 2. В интерфейсе CompItem должен быть объявлен метод getName() с типом возвращаемого значения String и без параметров.
 * 3. Классы Keyboard, Monitor и Mouse должны реализовывать интерфейс CompItem, а также существовать в отдельных файлах.
 * 4. Метод getName в классах реализующих интерфейс CompItem должен возвращать простое имя класса, например "Keyboard" для класса Keyboard.
 * 5. Класс Computer должен содержать по одному приватному полю типа Keyboard, Mouse, Monitor, а также существовать в отдельном файле.
 * 6. Конструктор класса Computer должен принимать 3 параметра(keyboard, mouse, monitor) и корректно инициализировать соответствующие поля класса.
 * 7. Для полей keyboard, mouse и monitor Computer должны быть созданы геттеры(getKeyboard, getMouse, getMonitor), которые будут возвращать соответствующие поля класса Computer.
 */

public class Task12 {
    public static void main(String[] args) {
        Computer computer = new Computer(new Keyboard(), new Mouse(), new Monitor());
        if (isWork(computer.getKeyboard()) &&
                isWork(computer.getMonitor()) &&
                isWork(computer.getMouse())) {
            System.out.println("Work!");
        }
    }

    public static boolean isWork(CompItem item) {
        System.out.println(item.getName());
        return item.getName() != null && item.getName().length() > 4;
    }

}
