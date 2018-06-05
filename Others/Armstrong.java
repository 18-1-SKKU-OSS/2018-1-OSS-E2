import java.util.Scanner;

/**
 * A utility to check if a given number is armstrong or not. Armstrong number is
 * a number that is equal to the sum of cubes of its digits for example 0, 1,
 * 153, 370, 371, 407 etc. For example 153 = 1^3 + 5^3 +3^3
 * 
 * �־��� ���ڰ� armstrong �������� �ƴ��� �Ǵ��մϴ�. armstrong ���ڶ� 
 * �� �ڸ����� �� ������ ���� �� ���ڿ� ���� ���� ���մϴ�. 
 * ���� ��� 153�� 153 = 1^3 + 5^3 + 3^3 �̱� ������ armstrong �����Դϴ�. 
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
	 * �־��� ���ڰ� armstrong �������� �ƴ��� �Ǵ��մϴ�. armstrong ���ڶ� 
	 * �� �ڸ����� �� ������ ���� �� ���ڿ� ���� ���� ���մϴ�. 
	 * ���� ��� 153�� 153 = 1^3 + 5^3 + 3^3 �̱� ������ armstrong �����Դϴ�. 
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