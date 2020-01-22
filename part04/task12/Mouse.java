package lesson05.part04.task12;
import lesson05.part04.task12.CompItem;

public class Mouse implements CompItem {
    public String getName(){
        return getClass().getSimpleName();
    }
}
