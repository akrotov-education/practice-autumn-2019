package lesson02.part01.task0307;
import java.util.ArrayList;
/* 
Привет StarCraft!
*/

public class Solution {
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
