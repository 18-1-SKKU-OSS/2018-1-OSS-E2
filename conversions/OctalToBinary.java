import java.util.Scanner;

/**
 * 8 ������ 2 ������ ��ȯ�մϴ�.
 * 
 * @author Zachary Jones
 *
 */
public class OctalToBinary {

	/**
	 * ���� �޼ҵ�
	 * 
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int o = sc.nextInt();
		System.out.println("Binary equivalent: " + convertOctalToBinary(o));
		sc.close();
	}
	
	/**
	 * �� �޼ҵ�� 8 ������ �������� ��ȯ�մϴ�.
	 * @param o -> 8����
	 */
	public static int convertOctalToBinary(int o) {
		Scanner scan;
		int num;
	
		void getVal() {
		
			System.out.println("Octal to Binary");
			scan = new Scanner(System.in);
			// �ʿ��� ���� �Է��մϴ�.
			System.out.println("\nEnter the number : ");
			num = Integer.parseInt(scan.nextLine(), 8);
		}
		
		void convert() {
		
			String binary = Integer.toBinaryString(num);		
			System.out.println("Binary Value is : " + binary);
		}
	}
}