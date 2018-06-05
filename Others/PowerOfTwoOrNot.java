import java.util.Scanner;

/**
*A utility to check if a given number is power of two or not.
*For example 8,16 etc.
*
* �־��� ���� 2�� �ŵ��������� Ȯ���մϴ�. 
* 2�� �ŵ������� ���δ� 8, 16, 32 ���� �ֽ��ϴ�. 
*
*/
public class PowerOfTwoOrNot {
	
	public static void main (String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int num = sc.nextInt();
		boolean isPowerOfTwo = checkIfPowerOfTwoOrNot(num);
		if (isPowerOfTwo) {
			System.out.println("Number is a power of two");
		} else {
			System.out.println("Number is not a power of two");
		}
	}


/**
* Checks whether given number is power of two or not.
* �־��� ���� 2�� �ŵ��������� Ȯ���մϴ�.
*
* @param number
* @return boolean
* 
* number��� ������ 2�� �ŵ��������� Ȯ�� �� �����Դϴ�.
* 2�� �ŵ������̸� true�� �����ϰ�, �ƴϸ� false�� �����մϴ�. 
* 
*/
public static boolean checkIfPowerOfTwoOrNot(int number) {
		return number != 0 && ((number & (number-1)) == 0);
	}

}
