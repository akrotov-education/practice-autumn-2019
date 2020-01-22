package lesson05.part04.task20;

public class Singleton {
    private static Singleton INSTANCE = new Singleton();
    private Singleton() {
    }
    public static Singleton getInstance() {
        if (INSTANCE == null){
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}