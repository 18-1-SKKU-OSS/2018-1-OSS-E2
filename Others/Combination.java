import java.util.Scanner;

public class Combination {
	public static void main(String args[]) {
		Scanner input1 = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		int n=0, r=0;
		System.out.print("Enter a non-negative n: ");
		try {
			n = input1.nextInt();
			while (n<0) {
				System.out.print("n must be non-negative, Enter non-negative number: ");
				n = input1.nextInt();
			}
		} catch (Exception e) {
			System.out.println("You didn't enter number");
		}
		System.out.print("Enter a non-negative, not larger than n, r: ");
		try {
			r = input2.nextInt();
			while (r < 0 || r > n) {
				System.out.println("r must be non-negative & not larger than n");
				System.out.print("Enter non-negative, not lager than n, r: ");
				r = input2.nextInt();
				}
			
			System.out.println(n+" combination "+r+" is "+combination(n,r));
		} catch (Exception e) {
			System.out.println("You didn't enter number");
		}
	
	
	}
	
	public static int combination(int n, int r) {
		if (n==r||r==0) return 1; 
		
		return combination(n-1, r-1)+combination(n-1, r);
	}
}
