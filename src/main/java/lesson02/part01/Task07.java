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
        zerg1.name = "Vasya";
        Zerg zerg2 = new Zerg();
        zerg2.name = "Petya";
        Zerg zerg3 = new Zerg();
        zerg3.name = "Vanya";
        Zerg zerg4 = new Zerg();
        zerg4.name = "Jenya";
        Zerg zerg5 = new Zerg();
        zerg5.name = "Sveta";

        Protoss prot1 = new Protoss();
        prot1.name = "Nastya";
        Protoss prot2 = new Protoss();
        prot2.name = "Lena";
        Protoss prot3 = new Protoss();
        prot3.name = "Katya";

        Terran terr1 = new Terran();
        terr1.name = "Misha";
        Terran terr2 = new Terran();
        terr2.name = "Pasha";
        Terran terr3 = new Terran();
        terr3.name = "Masha";
        Terran terr4 = new Terran();
        terr4.name = "Arina";
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
