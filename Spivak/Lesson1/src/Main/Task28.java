package Main;

public class Task28 {

    /**
     * �������� ����� print3. ����� ������ ������� �� ����� ���������� ������ 3 ����.
     * ������ ��� � ����� ������.
     * <p>
     * <p>
     * ����������:
     * 1. ��������� ������ �������� ����� �� �����.
     * 2. ����� main �� ������ �������� ������� System.out.println ��� System.out.print.
     * 3. ����� print3 ������ �������� ����� �� �����.
     * 4. ����� main ������ ������� ����� print3 ������ ���� ���.
     * 5. ����� print3 ������ �������� �� ����� ������ 3 ����. ������ ��� � ����� ������.
     */

    public static void print3(String s) {
        //�������� ��� ��� ���
    	for (int i = 0; i < 3; i++)
    		System.out.println(s);
    }

    public static void task() {
        print3("I love you!");
    }
}

