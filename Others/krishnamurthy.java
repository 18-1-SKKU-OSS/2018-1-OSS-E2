import java.util.Scanner;

/** 
 * This program checks whether the given number is Krishnamurthy number or not
 * Krishnamurthy number is a number which is equal to the sum of the factorials of all its digits.
 * 
 * �� ���α׷��� ���ڰ� Krishnamurthy ������ �ƴ����� �Ǵ��մϴ�. 
 * Krishnamurth ���� �� �ڸ������� ���(���丮��)�� ���� ���� ���� ���� ���� ���մϴ�. 
 * 
 * */

class krishnamurthy {
	
	/** 
	 * This method finds out the factorial of given number with recursive way.
	 * @param n is input number
	 * @return factorial of n
	 * 
	 * �� �޼���� ����� ������� ������� ã�Ƴ��ϴ�. 
	 * n�̶�� ������ �Է� �����Դϴ�. 
	 * n�� ���(n!) ���� �����մϴ�. 
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
		int saveNumber = number;     //save input number as number will be used to get digits.  �Է� ���ڴ� �ڸ����� ���ϴµ� ���̱� ������ ���� �����մϴ�. 
		while (number > 0) {
			digit = number % 10; 
			sum = sum + fact(digit);
			number = number / 10;  //to get next digit  ���� �ڸ����� ���ϱ� ���� ���ڸ� 10���� �������ݴϴ�. 
		}
		if (sum == saveNumber)
			System.out.print(saveNumber + " is a krishnamurthy number");
		else
			System.out.print(saveNumber + " is not a krishnamurthy number");
		scanNumber.close();
	}
}
