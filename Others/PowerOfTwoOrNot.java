import java.util.Scanner;

/**
*A utility to check if a given number is power of two or not.
*For example 8,16 etc.
*
* 주어진 수가 2의 거듭제곱인지 확인합니다. 
* 2의 거듭제곱의 예로는 8, 16, 32 등이 있습니다. 
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
* 주어진 수가 2의 거듭제곱인지 확인합니다.
*
* @param number
* @return boolean
* 
* number라는 변수는 2의 거듭제곱인지 확인 할 변수입니다.
* 2의 거듭제곱이면 true를 리턴하고, 아니면 false를 리턴합니다. 
* 
*/
public static boolean checkIfPowerOfTwoOrNot(int number) {
		return number != 0 && ((number & (number-1)) == 0);
	}

}
