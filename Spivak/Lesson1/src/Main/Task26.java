package Main;

public class Task26 {

    /**
     * �������� �������, ������� ��������� ������� �� ��� �����.
     * <p>
     * ���������:
     * ����� �������� ���� ������������ ������� min.
     * <p>
     * <p>
     * ����������:
     * 1. ��������� ������ �������� ����� �� �����.
     * 2. ����� min �� ������ �������� ����� �� �����.
     * 3. ����� main ������ ������� ����� min ������ ����.
     * 4. ����� main ������ �������� �� ����� ��������� ������ ������ min. ������ ��� � ����� ������.
     * 5. ����� min ������ ���������� ����������� �������� �� ����� a, b � �.
     */

    public static int min(int a, int b, int c) {
        //�������� ��� ��� ���
    	if (a < b && a < c)
    		return a;
    	else if (b < c)
		    	return b;
		    else
		    	return c;
    }

    public static void task() {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(5, 5, 10));
    }

}
