package Main;

public class Task09 {

    /**
     * ������ ��� ������ sumDigitsInNumber(int number). ����� �� ���� ��������� ����� ����������� �����. ����� ��������� ����� ���� ����� �����, � ������� ��� �����.
     * <p>
     * ������:
     * ����� sumDigitsInNumber ���������� � ���������� 546.
     * <p>
     * ������ ������:
     * 15
     * <p>
     * <p>
     * ����������:
     * 1. ��������� �� ������ ��������� ������ � ����������.
     * 2. ����� sumDigitsInNumber(int) ������ ���� ��������� � �����������.
     * 3. ����� sumDigitsInNumber ������ ���������� �������� ���� int.
     * 4. ����� sumDigitsInNumber �� ������ ������ �������� �� �����.
     * 5. ����� sumDigitsInNumber ������ ��������� ���������� ����� ���� ���� � ����� number.
     * 6. ��� ����� ���� �������� sout � ������ tab?
     */

    public static void task() {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //�������� ��� ��� ���
    	int sum = 0;
    	for (int i = 0; i < 3; i++)
    	{
	    	sum += Math.floorMod(number, 10);
	    	number = Math.floorDiv(number, 10);
    	}
        return sum;
    }
}
