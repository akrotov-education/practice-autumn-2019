package lesson05.part04.task12;
import lesson05.part04.task12.CompItem;

public class Monitor implements CompItem {
    public String getName(){
        return getClass().getSimpleName();
    }
}
