import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
  *"any"�� 2-36�� �ǹ��ϴ� ��� "any"���� "any"�� ��ȯ�ϱ����� Ŭ����.
? * �⺻ 1���� �Ҽ� 10 ������ �̵��Ͽ� �۵��մϴ�.
? * ���ڰ� Ư�� ���ؿ� ��ȿ���� ���θ� �����մϴ�.
 * 
 * @author Michael Rolland
 * @version 2017.10.10
 *
 */
public class AnyBaseToAnyBase {
	
	// ��ȿ�� �Է����� ����Ϸ��� �ּ� �� �ִ� ���̽�
	static final int MINIMUM_BASE = 2;
	static final int MAXIMUM_BASE = 36;
	
	// Driver
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String n;
		int b1 = 0,b2 = 0;
		while (true) {
			try {
				System.out.print("Enter number: ");
				n = in.next();
				System.out.print("Enter beginning base (between "+MINIMUM_BASE+" and "+MAXIMUM_BASE+"): ");
				b1 = in.nextInt();
				if (b1 > MAXIMUM_BASE || b1 < MINIMUM_BASE) {
					System.out.println("Invalid base!");
					continue;
				}
				if (!validForBase(n, b1)) {
					System.out.println("The number is invalid for this base!");
					continue;
				}
				System.out.print("Enter end base (between "+MINIMUM_BASE+" and "+MAXIMUM_BASE+"): ");
				b2 = in.nextInt();
				if (b2 > MAXIMUM_BASE || b2 < MINIMUM_BASE) {
					System.out.println("Invalid base!");
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input.");
				in.next();
			}
		}
		System.out.println(base2base(n, b1, b2));
	}
	
	/**
	 * ������ ���ڿ� ���� ���� (String)�� ��ȿ���� �˻��մϴ�.
	 */
	public static boolean validForBase(String n, int base) {
		char[] validDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
				'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z'};
		// digitsForBase�� �־��� �⺻�� ���� ��� ��ȿ ���ڸ� �����մϴ�.
		char[] digitsForBase = Arrays.copyOfRange(validDigits, 0, base);
		
		// contains () �޼����� ���Ǹ� ���� ���� �迭�� �������� ��ȯ�մϴ�.
		HashSet<Character> digitsList = new HashSet();
		for (int i=0; i<digitsForBase.length; i++)
			digitsList.add(digitsForBase[i]);
		
		// n�� ��� ���ڰ� �ش� ������ ��ȿ �ڸ��� ��Ͽ� �ִ��� Ȯ���Ͻʽÿ�.
		for (char c : n.toCharArray()) 
			if (!digitsList.contains(c))
				return false;
		
		return true;
	}
	
	/**
	 * �⺻ b1���� b2�� ������ ��ȯ�ϴ� �޼ҵ�. b1���� 10 ������ ��ȯ�Ͽ� �۵��մϴ�.
	* ���� �������� b2.
	* @param n ��ȯ �� ����.
	* @param b1 ���̽� ����.
	* @param b2 �� �����Դϴ�.
	 * @return n
	 */
	public static String base2base(String n, int b1, int b2) {
		// ���� ���� : 10 ���� �� n,
		//���̽� b1�� ����,���̽� b2�� ����,
	  	// �� ��ȯ �� ���ڿ��� ��ȯ�մϴ�.
		int decimalValue = 0, charB2;
		char charB1;
		String output="";
		// n�� ��� ���ڸ� ���캻��.
		for (int i=0; i<n.length(); i++) {
			// charB1�� ���ڸ� �����Ѵ�.
			charB1 = n.charAt(i);
			// ���ڰ� �ƴ� ��� 10 ���� ������ ��ȯ�Ͽ� charB2�� �����մϴ�.
			if (charB1 >= 'A' && charB1 <= 'Z') 
				charB2 = 10 + (charB1 - 'A');
			// �׷��� ������ ���� ���� charB2�� �����Ͻʽÿ�.
			else 
				charB2 = charB1 - '0';
			// �ڸ����� 10 ������ ��ȯ�ϰ�
	 		// n�� decimalValue = decimalValue * b1 + charB2;
		}
		
		// 10 ���� ���� �⺻ b2�� ��ȯ :
		// ���ڰ� �Ҽ����� �ٸ� �⺻���� ��ȯ�˴ϴ�.
		//���̽��� ��� ������
		// ���� 0�� �� ������ ������,
		// ���ο� ���̽��� �ִ� ���� �������̴�. ������ ��������
		// �� ���� �����Դϴ�.

		// ���� 0�� �ƴ� ���� :
		while (decimalValue != 0) {
			// �������� 10���� ���� ���� �� ���
			// ���ο� ��ȣ�� ����.
			if (decimalValue % b2 < 10) 
				output = Integer.toString(decimalValue % b2) + output;
			// ��������> = 10 �� ���
			// �� ���� �ش��ϴ� ��. (A = 10, B = 11, C = 12, ...)
			else
				output = (char)((decimalValue % b2)+55) + output;
			// �����̽��� �ٽ� �����ϴ�.
			decimalValue /= b2;
		}
		return output;
	}
}
