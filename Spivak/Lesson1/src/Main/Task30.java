package Main;

public class Task30 
{

    /*
     * � �������� ����������
     * � ������ main ������ ������ Man, ������� ������ �� ���� � ���������� man.
     * ������ ����� ������ Woman � ������� ������ �� ���� � ���������� woman.
     * <p>
     * ���������: ��� �������� ������� Woman � ��������� ��� ������ � ���������� woman ��������� �����������:
     * ��� ���������� ������������� = new ����������������������();
     * � man.wife ������� ������ �� ����� ��������� ������ Woman.
     * � woman.husband ������� ������ �� ����� ��������� ������ Man (���������: woman.husband = man;).
     * <p>
     * <p>
     * ����������:
     * 1. � ������ main ������ ������ Man � ����� ������� ������ �� ���� � ���������� man.
     * 2. � ������ main ������ ������ Woman � ����� ������� ������ �� ���� � ���������� woman.
     * 3. � ������ main ������� ������ �� ����� ��������� ������ Woman � man.wife.
     * 4. � ������ main ������� ������ �� ����� ��������� ������ Man � woman.husband.
     * 5. ����� Man ������ ��������� 3 ����������
     * 6. ����� Woman ������ ��������� 3 ����������
     */
	public static void task (){
		Task30.Man man = new Task30.Man();
		Task30.Woman woman = new Task30.Woman();
		
		man.wife = woman;
		woman.husband = man;
		
		System.out.println(man.wife);
		System.out.println(woman.husband);
	}
	
    public static class Man {
        public int age;
        public int height;
        public Woman wife;
    }

    public static class Woman {
        public int age;
        public int height;
        public Man husband;
    }
}
