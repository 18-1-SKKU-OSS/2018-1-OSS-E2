import java.util.Scanner;

/**
 * 8 진수를 2 진수로 변환합니다.
 * 
 * @author Zachary Jones
 *
 */
public class OctalToBinary {

	/**
	 * 메인 메소드
	 * 
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int o = sc.nextInt();
		System.out.println("Binary equivalent: " + convertOctalToBinary(o));
		sc.close();
	}
	
	/**
	 * 이 메소드는 8 진수를 이진수로 변환합니다.
	 * @param o -> 8진수
	 */
	public static int convertOctalToBinary(int o) {
		Scanner scan;
		int num;
	
		void getVal() {
		
			System.out.println("Octal to Binary");
			scan = new Scanner(System.in);
			// 필요한 수를 입력합니다.
			System.out.println("\nEnter the number : ");
			num = Integer.parseInt(scan.nextLine(), 8);
		}
		
		void convert() {
		
			String binary = Integer.toBinaryString(num);		
			System.out.println("Binary Value is : " + binary);
		}
	}
}