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
        zerg1.name = "Assdf";
        Zerg zerg2 = new Zerg();
        zerg1.name = "Gsded";
        Zerg zerg3 = new Zerg();
        zerg1.name = "Efdfd";
        Zerg zerg4 = new Zerg();
        zerg1.name = "Sfbdfg";
        Zerg zerg5 = new Zerg();
        zerg1.name = "Lfdvdf";

        Protoss protoss1 = new Protoss();
        protoss1.name = "Qsds";
        Protoss protoss2 = new Protoss();
        protoss1.name = "Hdsfd";
        Protoss protoss3 = new Protoss();
        protoss1.name = "Ekfjr";

        Terran terran1 = new Terran();
        terran1.name = "Qsds";
        Terran terran2 = new Terran();
        terran1.name = "Ksds";
        Terran terran3 = new Terran();
        terran1.name = "Rsks";
        Terran terran4 = new Terran();
        terran1.name = "Psps";
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
