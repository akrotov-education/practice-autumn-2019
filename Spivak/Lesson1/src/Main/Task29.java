package Main;

public class Task29 {

    /**
     * �������� ����� print3. ����� ������ ������� ���������� ������ (�����) �� ����� ��� ���� ����� ������.
     * <p>
     * <p>
     * ����������:
     * 1. ��������� ������ �������� ����� �� �����.
     * 2. ����� main �� ������ �������� ������� System.out.println ��� System.out.print.
     * 3. ����� print3 ������ �������� ����� �� �����.
     * 4. ����� main ������ ������� ����� print3 ����� ��� ����.
     * 5. ����� print3 ������ �������� ���������� ������ (�����) �� ����� ��� ����, �� � ����� ������.
     */

    public static void print3(String s) {
        //�������� ��� ��� ���
    	String st = s;
    	for (int i = 0; i < 2; i++)
    		st += " " + s;
    	System.out.println(st);
    }

    public static void task() {
        print3("window");
        print3("file");
    }
}