import java.util.*;
/**
 * 모든 이진수를 16 진수로 변환합니다.
 * 
 * @author Nishita Aggarwal
 *
 */
public class BinaryToHexadecimal {
   
	/**
	*이 메소드는 이진수를 16 진수로 변환합니다.
	* @param binary 이진수
	* @return 16 진수
	 */ 
	static String binaryToHex(int binary)
	{
		// hm 범위의 2 진수에 대한 16 진수 코드를 저장합니다. 0000에서 1111까지, 즉 10 진수 0에서 15까지
		HashMap<Integer,String> hm=new HashMap<>();	
		// 16 진수 코드를 저장할 문자열
		String hex="";
		int i;
		for(i=0 ; i<10 ; i++)
		{
			hm.put(i, String.valueOf(i));
		}
		for(i=10 ; i<16 ; i++)	hm.put(i,String.valueOf((char)('A'+i-10)));
		int currbit;
		while(binary != 0)
		{
			int code4 = 0;	// 4 진수로 구성된 숫자에 해당하는 10 진수를 저장합니다.
			for(i=0 ; i<4 ; i++)
			{
				currbit = binary % 10;
				binary = binary / 10;
				code4 += currbit * Math.pow(2, i);
			}
			hex= hm.get(code4) + hex;
		}
		return hex; 
	}
	
	/**
	 * 메인 메소드
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter binary number:");
		int binary = sc.nextInt();
		String hex = binToHex(binary);
		System.out.println("Hexadecimal Code:" + hex);
		sc.close();
	}
}
