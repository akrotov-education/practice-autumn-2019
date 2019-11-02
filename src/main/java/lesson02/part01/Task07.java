package lesson02.part01;
import java.util.ArrayList;
/**
 * Создать 5 зергов, 3 протосса и 4 террана.
 * Дать им всем уникальные имена.
 * <p>
 * <p>
 * Требования:
 * 1.	Нельзя изменять классы Zerg, Protoss и Terran.
 * 2.	Нужно создать 5 объектов типа Zerg и каждому из них дать свое имя.
 * 3.	Нужно создать 3 объекта типа Protoss и каждому из них дать свое имя.
 * 4.	Нужно создать 4 объекта типа Terran и каждому из них дать свое имя.
 */

public class Task07 {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Zerg> zergs = new ArrayList<>();
        for (int i = 0; i < 5; ++i){
            zergs.add(new Zerg());
            zergs.get(i).name = "Zergos" + i;
        }
        ArrayList<Protoss> protosses = new ArrayList<>();
        for (int i = 0; i < 3; ++i){
            protosses.add(new Protoss());
            protosses.get(i).name = "Proto" + i;
        }
        ArrayList<Terran> terrans = new ArrayList<>();
        for (int i = 0; i < 4; ++i){
            terrans.add(new Terran());
            terrans.get(i).name = "Terra"+i;
        }
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
