/**
 + + * 8 ������ 16������ ��ȯ�մϴ�.
 + + * 
 + + * @author Tanmay Joshi
 + + *
 + + *
 **/
import java.util.Scanner;

public class OctalToHexadecimal {
	
  /**
 + +	 * �� �޼ҵ�� 8 ������ �������� ��ȯ�մϴ�.
 + +	 * 
 + +	 */ 
 public static int OctToDec(String s)
 {
	 int i =0;
	 for(int j =0;j<s.length();j++)
	 {
		 char num = s.charAt(j);
		 num-='0';
		 i*=8;
		 i+=num;
	 }
	 return i;
}

/**
 + +	 *�� �޼ҵ�� �������� 16������ ��ȯ�մϴ�.
 + +	 * 
 + +	 */ 
public static String DecimalToHex(int d) {
    String digits = "0123456789ABCDEF";
    if (d <= 0) return "0"; 
 
    String hex = "";
    while (d > 0) {
        int digit = d % 16;              
        hex = digits.charAt(digit) + hex;
        d = d / 16;
    }
    return hex;
}

public static void main ( String args[]) {
		
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the Octal number: ");
     String oct  = input.next();                     //���ڿ����� ������� �Է����� 8 ������ �����ɴϴ�.
     int decimal = OctToDec(oct);                    //�Լ��� 8 ������ �����ϰ� ��ȯ �� 10 ���� ������ ����ϴ�.
     String hex = DecimalToHex(decimal);             //�Լ��� �������� �����ϰ� ������ 16 ���� �������� ��ȯ�մϴ�.
     System.out.println("The Hexadecimal equivalant is: "+hex);
 }
}

