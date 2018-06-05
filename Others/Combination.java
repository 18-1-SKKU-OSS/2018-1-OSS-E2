import java.util.Scanner;
/** 
 * This program will print out the combination of any non-negative
 * numbers that you input into it.
 * Combination is a selection of items from a collection. 
 * 
 * 이 프로그램은 양수들을 입력합고 그 양수들의 조합을 출력합니다. 
 * 조합은 한 집합에서 특정 수의 원소를 꺼내는 경우의 수입니다. 
 * 
 * @author MOOK2
 * */

public class Combination {
	/**
	 * The main method
	 * 메인 메서드
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
			while (n<0) { //n should be non-negative (n >= 0)  n은 음수가 아닌 수이여야 합니다. 
				System.out.print("n must be non-negative, Enter non-negative number: ");
				n = input1.nextInt();
			}
		} catch (Exception e) {
			System.out.println("You didn't enter number");
		}
		System.out.print("Enter a non-negative, not larger than n, r: ");
		try {
			r = input2.nextInt();
			while (r < 0 || r > n) { //r should be non-negative and not larger than n, (r >= 0 && n >= r) r은 음수가 아닌 수이면서 n보다는 작아야합니다. 
				System.out.println("r must be non-negative & not larger than n");
				System.out.print("Enter non-negative, not lager than n, r: ");
				r = input2.nextInt();
				}
			//Display the result  결과를 출력합니다. 
			System.out.println(n+" combination "+r+" is "+combination(n,r));
		} catch (Exception e) {
			System.out.println("You didn't enter number");
		}
	
	
	}
	/**
	 * Recursive Combination Method
	 * 재귀적인 방법으로 조합을 계산합니다. 
	 * 
	 * @param n The number to combination  (from n elements)
	 * @param r The number to combination  (chose r elements)
	 * @return The combination of the number
	 * 
	 * 
	 * n이라는 변수는 조합의 계산에 사용되는 변수입니다. (전체 집합의 수가 n개)
	 * r이라는 변수는 조합늬 계산에 사용되는 변수입니다. (r개를 뽑음)
	 * 조합의 수를 리턴합니다. 
	 */
	public static int combination(int n, int r) {
		if (n==r||r==0) return 1; 
		
		return combination(n-1, r-1)+combination(n-1, r);
	}
}
