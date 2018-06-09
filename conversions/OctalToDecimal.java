import java.util.Scanner;

/**
 * 8 ������ 10 ������ ��ȯr
 * 
 * @author Zachary Jones
 *
 */
public class OctalToDecimal {

	/**
	 * ���� �޼ҵ�
	 * 
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Octal Input: ");
		String inputOctal = sc.nextLine();
		int result = convertOctalToDecimal(inputOctal);
		if (result != -1)
			System.out.println("Result convertOctalToDecimal : " + result);
		sc.close();
	}

	/**
	 * �� �޼ҵ�� 8 ������ 10 ������ ��ȯ�մϴ�
	 * 
	 */
	public static int convertOctalToDecimal(String inputOctal) {

		try {
			// Octal���� Decimal ���� ���� ��ȯ 
			Integer outputDecimal = Integer.parseInt(inputOctal, 8);
			return outputDecimal;
		} catch (NumberFormatException ne) {
			// Printing a warning message if the input is not a valid octal
			// number:
			System.out.println("Invalid Input, Expecting octal number 0-7");
			return -1;
		}
	}
}