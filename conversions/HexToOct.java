/**
 + * 16 진수를 8 진수로 변환합니다.
 + * 
 + * @author Tanmay Joshi
 + *
 + */
import java.util.Scanner;

public class HexToOct
{ 
	/**
 +	 * 이 메서드는 16 진수를 10 진수로 변환합니다.
 +	 *  
 +	 */ 
    public static int hex2decimal(String s)
    {
             String str = "0123456789ABCDEF";  
             s = s.toUpperCase();
             int val = 0;
             for (int i = 0; i < s.length(); i++)
             {
                 char a = s.charAt(i);
                 int n = str.indexOf(a);
                 val = 16*val + n;
             }
             return val;
    } 
	
	/**
 +	 * 이 메서드는 10 진수를 8 진수로 변환합니다.
 +	 * 
 +	 */ 
	public static int decimal2octal(int q)
	{
		int now;
		int i=1;
		int octnum=0;
		while(q>0)
		{
			now=q%8;
			octnum=(now*(int)(Math.pow(10,i)))+octnum;
			q/=8;
			i++;
		}
		octnum/=10;
		return octnum;
	}
	// 사용자로부터 16 진수 입력을 받아 이를 8 진법으로 변환하는 주요 메소드.
    public static void main(String args[])
    {
        String hexadecnum;
        int decnum,octalnum;
        Scanner scan = new Scanner(System.in);
		
        System.out.print("Enter Hexadecimal Number : ");
        hexadecnum = scan.nextLine();      
        
        // 먼저 16 진수를 10 진수로 변환합니다.
        
        decnum = hex2decimal(hexadecnum);      // 문자열을 hex2decimal 함수에 전달하고 decnum 변수에 10 진수 형식을 가져옵니다.
		
       // 10 진수를 8 진수로 변환합니다.
        octalnum=decimal2octal(decnum);
	System.out.println("Number in octal: "+octalnum);
 
        
    }
}
