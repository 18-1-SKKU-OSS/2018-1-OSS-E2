import java.util.Scanner;

/**
 * 이진수를 8 진수로 변환합니다.
 * 
 * @author Zachary Jones
 *
 */
public class BinaryToOctal {
	
	/**
	 * 메인 메소드
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt();
		System.out.println("Octal equivalent: " + convertBinaryToOctal(b));
		sc.close();
		
	}
	
	/**
	*이 방법은 이진수를
	* 8 진수로 변환합니다
	 * 
	* @param b 이진수
	* @return 8 진수
	 */
	public static int convertBinaryToOctal(int b) {
		int o = 0, r=0, j =1 ;
		while(b!=0)
		{
			r = b % 10;
        		o = o + r * j;
       			j = j * 2;
        		b = b / 10;
		}
		return o;
	}

}
