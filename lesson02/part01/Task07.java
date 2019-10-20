package lesson02.part01;

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
        Zerg zerg1 = new Zerg();
        Zerg zerg2 = new Zerg();
        Zerg zerg3 = new Zerg();
        Zerg zerg4 = new Zerg();
        Zerg zerg5 = new Zerg();

        zerg1.name = " z1 ";
        zerg2.name = " z2 ";
        zerg3.name = " z3 ";
        zerg4.name = " z4 ";
        zerg5.name = " z5 ";

        Protoss prot1 = new Protoss();
        Protoss prot2 = new Protoss();
        Protoss prot3 = new Protoss();

        prot1.name = " p1 ";
        prot2.name = " p2 ";
        prot3.name = " p3 ";

        Terran ter1 = new Terran();
        Terran ter2 = new Terran();
        Terran ter3 = new Terran();
        Terran ter4 = new Terran();

        ter1.name = " t1 ";
        ter2.name = " t2 ";
        ter3.name = " t3 ";
        ter4.name = " t4 ";


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
