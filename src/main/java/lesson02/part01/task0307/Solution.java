package lesson02.part01.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Zerg z1 = new Zerg();
        z1.name = "A";
        Zerg z2 = new Zerg();
        z2.name = "B";
        Zerg z3 = new Zerg();
        z3.name = "C";
        Zerg z4 = new Zerg();
        z4.name = "D";
        Zerg z5 = new Zerg();
        z5.name = "E";

        Protoss p1 = new Protoss();
        p1.name = "F";
        Protoss p2 = new Protoss();
        p2.name = "G";
        Protoss p3 = new Protoss();
        p3.name = "H";

        Terran t1 = new Terran();
        t1.name = "J";
        Terran t2 = new Terran();
        t2.name = "I";
        Terran t3 = new Terran();
        t3.name = "O";
        Terran t4 = new Terran();
        t4.name = "P";
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
