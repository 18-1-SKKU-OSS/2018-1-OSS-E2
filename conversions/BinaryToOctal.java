import java.util.Scanner;

/**
 * �������� 8 ������ ��ȯ�մϴ�.
 * 
 * @author Zachary Jones
 *
 */
public class BinaryToOctal {
	
	/**
	 * ���� �޼ҵ�
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt();
		System.out.println("Octal equivalent: " + convertBinaryToOctal(b));
		sc.close();
		
	}
	
	/**
	*�� ����� ��������
	* 8 ������ ��ȯ�մϴ�
	 * 
	* @param b ������
	* @return 8 ����
	 */
	public static int convertBinaryToOctal(int b) {
		int o = 0, r=0, j =1 ;
		while(b!=0)
		{
			r = b % 10;
        		o = o + r * j;
       			j = j * 2;
        		b = b / 10;
		}
		return o;
	}

}
