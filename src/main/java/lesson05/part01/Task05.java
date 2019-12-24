package lesson05.part01;

/**
 * ИТ-компания
 * Исправить девять классов: Worker (сотрудник), Clerk (клерк), IT (ИТ-специалист),
 * Programmer (программист), ProjectManager (менеджер проекта), CTO (технический директор),
 * HR (рекрутер), OfficeManager (офис-менеджер), Cleaner (уборщик).
 * Унаследовать программиста, менеджера проекта и технического директора от ИТ-специалиста.
 * Унаследовать рекрутера, уборщика и офис-менеджера от клерка.
 * Унаследовать клерка и ИТ-специалиста от сотрудника.
 * <p>
 * <p>
 * Требования:
 * 1. В классе задачи должен быть public класс Worker (сотрудник).
 * 2. В классе задачи должен быть public класс Clerk (клерк).
 * 3. В классе задачи должен быть public класс IT (ИТ-специалист).
 * 4. В классе задачи должен быть public класс Programmer (программист).
 * 5. В классе задачи должен быть public класс ProjectManager (менеджер проекта).
 * 6. В классе задачи должен быть public класс CTO (технический директор).
 * 7. В классе задачи должен быть public класс HR (рекрутер).
 * 8. В классе задачи должен быть public класс OfficeManager (офис-менеджер).
 * 9. В классе задачи должен быть public класс Cleaner (уборщик).
 * 10. Классы Programmer, ProjectManager и CTO должны быть унаследованы от класса IT.
 * 11. Классы HR, Cleaner и OfficeManager должны быть унаследованы от класса Clerk.
 * 12. Классы Clerk и IT должны быть унаследованы от класса Worker.
 */

public class Task05 {
    public static void main(String[] args) {
    }

    public class Worker {

    }

    public class Clerk extends Worker {

    }

    public class IT extends Worker {

    }

    public class Programmer extends IT {

    }

    public class ProjectManager extends IT {

    }

    public class CTO extends IT {

    }

    public class OfficeManager extends Clerk {

    }

    public class HR extends Clerk {

    }

    public class Cleaner extends Clerk {

    }
}