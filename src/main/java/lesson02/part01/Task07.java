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
        zerg1.name = "Kerrigan";
        Zerg zerg2 = new Zerg();
        zerg2.name = "Abathur";
        Zerg zerg3 = new Zerg();
        zerg3.name = "Zergling";
        Zerg zerg4 = new Zerg();
        zerg4.name = "Hydralisk";
        Zerg zerg5 = new Zerg();
        zerg5.name = "Defiler";

        Protoss protoss1 = new Protoss();
        protoss1.name = "Zealot";
        Protoss protoss2 = new Protoss();
        protoss2.name = "Archon";
        Protoss protoss3 = new Protoss();
        protoss3.name = "Reaver";

        Terran terran1 = new Terran();
        terran1.name = "Marine ";
        Terran terran2 = new Terran();
        terran2.name = "Medic";
        Terran terran3 = new Terran();
        terran3.name = "Firebat ";
        Terran terran4 = new Terran();
        terran4.name = "Ghost";

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
