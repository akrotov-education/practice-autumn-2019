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
        Zerg zerg1 = new Zerg();
        zerg1.name = "kek";
        Zerg zerg2 = new Zerg();
        zerg2.name = "ke2";
        Zerg zerg3 = new Zerg();
        zerg3.name = "ke3";
        Zerg zerg4 = new Zerg();
        zerg4.name = "kek4";
        Zerg zerg5 = new Zerg();
        zerg5.name = "ke5";

        Protoss lol1 = new Protoss();
        lol1.name = "lol1";
        Protoss lol2 = new Protoss();
        Protoss lol3 = new Protoss();
        lol2.name = "lol2";
        lol3.name = "lol3";

        Terran tr1 = new Terran();
        Terran tr2 = new Terran();
        Terran tr3 = new Terran();
        Terran tr4 = new Terran();
        tr1.name = "of";
        tr2.name = "of1";
        tr3.name = "of4";
        tr4.name = "of4fdddd";

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
