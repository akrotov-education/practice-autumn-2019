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
        Zerg zerg1=new Zerg();
        Zerg zerg2=new Zerg();
        Zerg zerg3=new Zerg();
        Zerg zerg4=new Zerg();
        Zerg zerg5=new Zerg();

        Protoss protoss1=new Protoss();
        Protoss protoss2=new Protoss();
        Protoss protoss3=new Protoss();

        Terran terran1=new Terran();
        Terran terran2=new Terran();
        Terran terran3=new Terran();
        Terran terran4=new Terran();

        zerg1.name="Zerg 1";
        zerg2.name="Zerg 2";
        zerg3.name="Zerg 3";
        zerg4.name="Zerg 4";
        zerg5.name="Zerg 5";

        protoss1.name="Protoss 1";
        protoss2.name="Protoss 2";
        protoss3.name="Protoss 3";

        terran1.name="Terran 1";
        terran2.name="Terran 2";
        terran3.name="Terran 3";
        terran4.name="Terran 4";

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
