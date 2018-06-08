import java.util.*;
/**
 * ��� �������� 16 ������ ��ȯ�մϴ�.
 * 
 * @author Nishita Aggarwal
 *
 */
public class BinaryToHexadecimal {
   
	/**
	*�� �޼ҵ�� �������� 16 ������ ��ȯ�մϴ�.
	* @param binary ������
	* @return 16 ����
	 */ 
	static String binaryToHex(int binary)
	{
		// hm ������ 2 ������ ���� 16 ���� �ڵ带 �����մϴ�. 0000���� 1111����, �� 10 ���� 0���� 15����
		HashMap<Integer,String> hm=new HashMap<>();	
		// 16 ���� �ڵ带 ������ ���ڿ�
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
			int code4 = 0;	// 4 ������ ������ ���ڿ� �ش��ϴ� 10 ������ �����մϴ�.
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
	 * ���� �޼ҵ�
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
