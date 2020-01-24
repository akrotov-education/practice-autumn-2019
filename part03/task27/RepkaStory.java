package lesson05.part03.task27;

import java.util.ArrayList;
import java.util.List;

public class RepkaStory {
    static void tell(ArrayList<lesson05.part03.task27.Person> items) {
        Person first;
        Person second;
        for (int i = items.size() - 1; i > 0; i--) {
            first = items.get(i);
            second = items.get(i - 1);
            first.pull(second);
        }
    }
}
