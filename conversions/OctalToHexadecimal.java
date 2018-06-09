/**
 + + * 8 진수를 16진수로 변환합니다.
 + + * 
 + + * @author Tanmay Joshi
 + + *
 + + *
 **/
import java.util.Scanner;

public class OctalToHexadecimal {
	
  /**
 + +	 * 이 메소드는 8 진수를 십진수로 변환합니다.
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
 + +	 *이 메소드는 십진수를 16진수로 변환합니다.
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
     String oct  = input.next();                     //문자열에서 사용자의 입력으로 8 진수를 가져옵니다.
     int decimal = OctToDec(oct);                    //함수에 8 진수를 전달하고 변환 된 10 진수 형식을 얻습니다.
     String hex = DecimalToHex(decimal);             //함수에 십진수를 전달하고 숫자의 16 진수 형식으로 변환합니다.
     System.out.println("The Hexadecimal equivalant is: "+hex);
 }
}

