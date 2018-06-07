import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
  *"any"가 2-36을 의미하는 경우 "any"에서 "any"로 변환하기위한 클래스.
? * 기본 1에서 소수 10 진수로 이동하여 작동합니다.
? * 숫자가 특정 기준에 유효한지 여부를 결정합니다.
 * 
 * @author Michael Rolland
 * @version 2017.10.10
 *
 */
public class AnyBaseToAnyBase {
	
	// 유효한 입력으로 허용하려는 최소 및 최대 베이스
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
	 * 지정된 숫자에 대해 숫자 (String)가 유효한지 검사합니다.
	 */
	public static boolean validForBase(String n, int base) {
		char[] validDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
				'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z'};
		// digitsForBase는 주어진 기본에 대한 모든 유효 숫자를 포함합니다.
		char[] digitsForBase = Arrays.copyOfRange(validDigits, 0, base);
		
		// contains () 메서드의 편의를 위해 문자 배열을 집합으로 변환합니다.
		HashSet<Character> digitsList = new HashSet();
		for (int i=0; i<digitsForBase.length; i++)
			digitsList.add(digitsForBase[i]);
		
		// n의 모든 숫자가 해당 기준의 유효 자릿수 목록에 있는지 확인하십시오.
		for (char c : n.toCharArray()) 
			if (!digitsList.contains(c))
				return false;
		
		return true;
	}
	
	/**
	 * 기본 b1에서 b2로 정수를 변환하는 메소드. b1에서 10 진수로 변환하여 작동합니다.
	* 다음 십진수는 b2.
	* @param n 변환 할 정수.
	* @param b1 베이스 기준.
	* @param b2 끝 기준입니다.
	 * @return n
	 */
	public static String base2base(String n, int b1, int b2) {
		// 변수 선언 : 10 진수 값 n,
		//베이스 b1의 문자,베이스 b2의 문자,
	  	// 및 반환 될 문자열을 반환합니다.
		int decimalValue = 0, charB2;
		char charB1;
		String output="";
		// n의 모든 문자를 살펴본다.
		for (int i=0; i<n.length(); i++) {
			// charB1에 문자를 저장한다.
			charB1 = n.charAt(i);
			// 숫자가 아닌 경우 10 진수 값으로 변환하여 charB2에 저장합니다.
			if (charB1 >= 'A' && charB1 <= 'Z') 
				charB2 = 10 + (charB1 - 'A');
			// 그렇지 않으면 정수 값을 charB2에 저장하십시오.
			else 
				charB2 = charB1 - '0';
			// 자릿수를 10 진수로 변환하고
	 		// n의 decimalValue = decimalValue * b1 + charB2;
		}
		
		// 10 진수 값을 기본 b2로 변환 :
		// 숫자가 소수에서 다른 기본으로 변환됩니다.
		//베이스로 계속 나눈다
		// 몫이 0이 될 때까지 나머지,
		// 새로운 베이스에 있는 수는 나머지이다. 마지막 나머지는
		// 맨 왼쪽 숫자입니다.

		// 몫이 0이 아닌 동안 :
		while (decimalValue != 0) {
			// 나머지가 10보다 작은 숫자 인 경우
			// 새로운 번호의 왼쪽.
			if (decimalValue % b2 < 10) 
				output = Integer.toString(decimalValue % b2) + output;
			// 나머지가> = 10 인 경우
			// 새 값에 해당하는 값. (A = 10, B = 11, C = 12, ...)
			else
				output = (char)((decimalValue % b2)+55) + output;
			// 새베이스로 다시 나눕니다.
			decimalValue /= b2;
		}
		return output;
	}
}
