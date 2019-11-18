package lesson05.part04;

/**
 * Без ошибок
 * Инициализировать объект obj таким классом, чтобы метод main выполнился без ошибок.
 * <p>
 * <p>
 * Требования:
 * 1. Класс GrayMouse должен наследоваться от класса Mouse.
 * 2. Класс Jerry должен наследоваться от класса GrayMouse.
 * 3. В переменной obj должен храниться объект который будет одновременно являться и Mouse, и GrayMouse, и Jerry.
 * 4. Метод main должен вызывать метод printClasses.
 */

public class Task05 {
//    public static void main(String[] args) {
//        Object obj = //Add your code here
//
//                Mouse mouse = (Mouse) obj;
//        GrayMouse grayMouse = (GrayMouse) mouse;
//        Jerry jerry = (Jerry) grayMouse;
//
//        printClasses(obj, mouse, grayMouse, jerry);
//
//    }

    public static void printClasses(Object obj, Mouse mouse, GrayMouse grayMouse, Jerry jerry) {
        System.out.println(jerry.getClass().getSimpleName());
        System.out.println(grayMouse.getClass().getSimpleName());
        System.out.println(mouse.getClass().getSimpleName());
        System.out.println(obj.getClass().getSimpleName());
    }

    static class Mouse {
    }

    static class GrayMouse extends Mouse {
    }

    static class Jerry extends GrayMouse {
    }
}
