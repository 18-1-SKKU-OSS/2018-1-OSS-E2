/**
 + * 16 ������ 8 ������ ��ȯ�մϴ�.
 + * 
 + * @author Tanmay Joshi
 + *
 + */
import java.util.Scanner;

public class HexToOct
{ 
	/**
 +	 * �� �޼���� 16 ������ 10 ������ ��ȯ�մϴ�.
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
 +	 * �� �޼���� 10 ������ 8 ������ ��ȯ�մϴ�.
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
	// ����ڷκ��� 16 ���� �Է��� �޾� �̸� 8 �������� ��ȯ�ϴ� �ֿ� �޼ҵ�.
    public static void main(String args[])
    {
        String hexadecnum;
        int decnum,octalnum;
        Scanner scan = new Scanner(System.in);
		
        System.out.print("Enter Hexadecimal Number : ");
        hexadecnum = scan.nextLine();      
        
        // ���� 16 ������ 10 ������ ��ȯ�մϴ�.
        
        decnum = hex2decimal(hexadecnum);      // ���ڿ��� hex2decimal �Լ��� �����ϰ� decnum ������ 10 ���� ������ �����ɴϴ�.
		
       // 10 ������ 8 ������ ��ȯ�մϴ�.
        octalnum=decimal2octal(decnum);
	System.out.println("Number in octal: "+octalnum);
 
        
    }
}
