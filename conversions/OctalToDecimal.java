import java.util.Scanner;

/**
 * 8 진수를 10 진수로 변환r
 * 
 * @author Zachary Jones
 *
 */
public class OctalToDecimal {

	/**
	 * 메인 메소드
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
	 * 이 메소드는 8 진수를 10 진수로 변환합니다
	 * 
	 */
	public static int convertOctalToDecimal(String inputOctal) {

		try {
			// Octal에서 Decimal 로의 실제 변환 
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