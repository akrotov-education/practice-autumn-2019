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
        Zerg zerg2 = new Zerg();
        Zerg zerg3 = new Zerg();
        Zerg zerg4 = new Zerg();
        Zerg zerg5 = new Zerg();
        zerg1.name = "first zerg";
        zerg2.name = "second zerg";
        zerg3.name = "third zerg";
        zerg4.name = "fourth zerg";
        zerg5.name = "fifth zerg";

        Protoss prot1 = new Protoss();
        Protoss prot2 = new Protoss();
        Protoss prot3 = new Protoss();
        prot1.name = "first prot";
        prot2.name = "second prot";
        prot3.name = "third prot";

        Terran terr1 = new Terran();
        Terran terr2 = new Terran();
        Terran terr3 = new Terran();
        Terran terr4 = new Terran();
        terr1.name = "first terr";
        terr1.name = "second terr";
        terr1.name = "third terr";
        terr1.name = "fourth terr";
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
