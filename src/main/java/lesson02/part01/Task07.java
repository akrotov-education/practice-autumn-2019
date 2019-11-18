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
        Zerg zerg_1=new Zerg();
        zerg_1.name="Abc";
        Zerg zerg_2 = new Zerg();
        zerg_2.name = "Bca";
        Zerg zerg_3 = new Zerg();
        zerg_3.name = "Cab";
        Zerg zerg_4 = new Zerg();
        zerg_4.name = "Aaa";
        Zerg zerg_5 = new Zerg();
        zerg_5.name = "Bbb";

        Protoss protoss1 = new Protoss();
        protoss1.name = "zxcv";
        Protoss protoss2 = new Protoss();
        protoss1.name = "mbn";
        Protoss protoss3 = new Protoss();
        protoss1.name = "lker";

        Terran terran1 = new Terran();
        terran1.name = "ler";
        Terran terran2 = new Terran();
        terran1.name = "erg";
        Terran terran3 = new Terran();
        terran1.name = "erfg";
        Terran terran4 = new Terran();
        terran1.name = "werg";
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
