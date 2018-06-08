import java.util.Scanner;

/** 
 * This program checks whether the given number is Krishnamurthy number or not
 * Krishnamurthy number is a number which is equal to the sum of the factorials of all its digits.
 * 
 * 이 프로그램은 숫자가 Krishnamurthy 수인지 아닌지를 판단합니다. 
 * Krishnamurth 수란 각 자리수들의 계승(팩토리얼)의 합이 본래 수와 같은 수를 말합니다. 
 * 
 * */

class krishnamurthy {
	
	/** 
	 * This method finds out the factorial of given number with recursive way.
	 * @param n is input number
	 * @return factorial of n
	 * 
	 * 이 메서드는 계승을 재귀적인 방법으로 찾아냅니다. 
	 * n이라는 변수는 입력 숫자입니다. 
	 * n의 계승(n!) 값을 리턴합니다. 
	 * */
	static int fact(int n) {
		if (n==0||n==1) return 1;
		return n * fact(n-1);
	}

	public static void main(String args[]) {
		Scanner scanNumber = new Scanner(System.in);
		int number, digit, sum = 0;
		System.out.print("Enter the number : "); 
		
		number = scanNumber.nextInt();
		int saveNumber = number;     //save input number as number will be used to get digits.  입력 숫자는 자릿수를 구하는데 쓰이기 때문에 따로 저장합니다. 
		while (number > 0) {
			digit = number % 10; 
			sum = sum + fact(digit);
			number = number / 10;  //to get next digit  다음 자리수를 구하기 위해 숫자를 10으로 나누어줍니다. 
		}
		if (sum == saveNumber)
			System.out.print(saveNumber + " is a krishnamurthy number");
		else
			System.out.print(saveNumber + " is not a krishnamurthy number");
		scanNumber.close();
	}
}
