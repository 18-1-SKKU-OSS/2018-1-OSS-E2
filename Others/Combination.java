import java.util.Scanner;
/** 
 * This program will print out the combination of any non-negative
 * numbers that you input into it.
 * Combination is a selection of items from a collection. 
 * 
 * �� ���α׷��� ������� �Է��հ� �� ������� ������ ����մϴ�. 
 * ������ �� ���տ��� Ư�� ���� ���Ҹ� ������ ����� ���Դϴ�. 
 * 
 * @author MOOK2
 * */

public class Combination {
	/**
	 * The main method
	 * ���� �޼���
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String args[]) {
		Scanner input1 = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		int n=0, r=0;
		System.out.print("Enter a non-negative n: ");
		try {
			n = input1.nextInt();
			while (n<0) { //n should be non-negative (n >= 0)  n�� ������ �ƴ� ���̿��� �մϴ�. 
				System.out.print("n must be non-negative, Enter non-negative number: ");
				n = input1.nextInt();
			}
		} catch (Exception e) {
			System.out.println("You didn't enter number");
		}
		System.out.print("Enter a non-negative, not larger than n, r: ");
		try {
			r = input2.nextInt();
			while (r < 0 || r > n) { //r should be non-negative and not larger than n, (r >= 0 && n >= r) r�� ������ �ƴ� ���̸鼭 n���ٴ� �۾ƾ��մϴ�. 
				System.out.println("r must be non-negative & not larger than n");
				System.out.print("Enter non-negative, not lager than n, r: ");
				r = input2.nextInt();
				}
			//Display the result  ����� ����մϴ�. 
			System.out.println(n+" combination "+r+" is "+combination(n,r));
		} catch (Exception e) {
			System.out.println("You didn't enter number");
		}
	
	
	}
	/**
	 * Recursive Combination Method
	 * ������� ������� ������ ����մϴ�. 
	 * 
	 * @param n The number to combination  (from n elements)
	 * @param r The number to combination  (chose r elements)
	 * @return The combination of the number
	 * 
	 * 
	 * n�̶�� ������ ������ ��꿡 ���Ǵ� �����Դϴ�. (��ü ������ ���� n��)
	 * r�̶�� ������ ���մ� ��꿡 ���Ǵ� �����Դϴ�. (r���� ����)
	 * ������ ���� �����մϴ�. 
	 */
	public static int combination(int n, int r) {
		if (n==r||r==0) return 1; 
		
		return combination(n-1, r-1)+combination(n-1, r);
	}
}
