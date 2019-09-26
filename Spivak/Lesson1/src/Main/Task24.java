package Main;

public class Task24 {

    /**
     * ������ ������ ���� Cat (���), ������ ���� Dog (������), ������ ���� Fish (�����) � ������ ���� Woman.
     * ������� ������� ��������� ��������� (owner).
     * <p>
     * <p>
     * ����������:
     * 1. ��������� �� ������ �������� ����� �� �����.
     * 2. � ������ main ������ ������� ���� Cat, Dog, Fish, Woman ������ �� ������ � ����������.
     * 3. � ������ main ��������� ������� ��������� ��������� Woman.
     * 4. ����� Cat, Dog, Fish ������ ��������� ������ ���� ���������� Woman owner.
     * 5. ����� Woman �� ������ ��������� ����������.
     */

    public static void task() {
        //�������� ��� ��� ���
    	Cat cat = new Cat();
    	Dog dog = new Dog();
    	Fish fish = new Fish();
    	
    	Woman woman = new Woman();
    	
    	cat.owner = woman;
    	dog.owner = woman;
    	fish.owner = woman;
    }

    public static class Cat {
        public Woman owner;
    }

    public static class Dog {
        public Woman owner;
    }

    public static class Fish {
        public Woman owner;
    }

    public static class Woman {
    }
}
