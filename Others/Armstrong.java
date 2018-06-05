import java.util.Scanner;

/**
 * A utility to check if a given number is armstrong or not. Armstrong number is
 * a number that is equal to the sum of cubes of its digits for example 0, 1,
 * 153, 370, 371, 407 etc. For example 153 = 1^3 + 5^3 +3^3
 * 
 * 주어진 숫자가 armstrong 숫자인지 아닌지 판단합니다. armstrong 숫자란 
 * 각 자릿수의 세 제곱의 합이 그 숫자와 같은 수를 말합니다. 
 * 예를 들어 153은 153 = 1^3 + 5^3 + 3^3 이기 때문에 armstrong 숫자입니다. 
 * 
 * @author mani manasa mylavarapu
 * 
 */
public class Armstrong {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("please enter the number");
		int n = scan.nextInt();
		boolean isArmstrong = checkIfANumberIsAmstrongOrNot(n);
		if (isArmstrong) {
			System.out.println("the number is armstrong");
		} else {
			System.out.println("the number is not armstrong");
		}
	}

	/**
	 * Checks whether a given number is an armstrong number or not. Armstrong
	 * number is a number that is equal to the sum of cubes of its digits for
	 * example 0, 1, 153, 370, 371, 407 etc.
	 * 
	 * 주어진 숫자가 armstrong 숫자인지 아닌지 판단합니다. armstrong 숫자란 
	 * 각 자릿수의 세 제곱의 합이 그 숫자와 같은 수를 말합니다. 
	 * 예를 들어 153은 153 = 1^3 + 5^3 + 3^3 이기 때문에 armstrong 숫자입니다. 
	 * 
	 * @param number
	 * @return boolean
	 */
	public static boolean checkIfANumberIsAmstrongOrNot(int number) {
		int remainder, sum = 0, temp = 0;
		temp = number;
		while (number > 0) {
			remainder = number % 10;
			sum = sum + (remainder * remainder * remainder);
			number = number / 10;
		}
		if (sum == temp) {
			return true;
		} else {
			return false;
		}

	}
}