package Main;

public class Task27 {

    /**
     * �������� �������, ������� ��������� ������� �� ������ �����.
     * ������� min(a,b,c,d) ������ ������������ (��������) ������� min(a,b)
     * <p>
     * ���������:
     * ����� �������� ���� ���� ������������ ������� min.
     * <p>
     * <p>
     * ����������:
     * 1. ��������� ������ �������� ����� �� �����.
     * 2. ������ min �� ������ �������� ����� �� �����.
     * 3. ����� main ������ �������� ����� min(a, b) � ����� min(a, b, c, d).
     * 4. ����� main ������ �������� �� ����� ��������� ������ ������� min. ������ ��� � ����� ������.
     * 5. ����� min(a, b) ������ ���������� ����������� �������� �� ����� a, b.
     * 6. ����� min(a, b, c, d) ������ ������������ ����� min(a, b)
     * 7. ����� min(a, b, c, d) ������ ���������� ����������� �������� �� ����� a, b, c, d.
     */

    public static int min(int a, int b, int c, int d) {
        //�������� ��� ��� ���
        return min(min(a, b), min(c, d));
    }

    public static int min(int a, int b) {
        //�������� ��� ��� ���
    	if (a < b)
    		return a;
    	else
    		return b;
    }

    public static void task() throws Exception {
        System.out.println(min(-20, -10));
        System.out.println(min(-40, -10, -30, 40));
        System.out.println(min(-20, -40, -30, 40));
        System.out.println(min(-20, -10, -40, 40));
        System.out.println(min(-20, -10, -30, -40));
    }
}