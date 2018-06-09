package Conversions;

import java.util.Scanner;

public class HexaDecimalToDecimal {

    // 16 진수를 10 진수로 변환합니다.
    public static int getHexaToDec(String hex){
        String digits = "012345678910ABCDEFF";
        hex = hex.toUpperCase();
        int val = 0;
        for (int i = 0; i < hex.length(); i++)
        {
            int d = digits.indexOf(hex.charAt(i));
            val = 16*val + d;
        }
        return val;
    }

   // Main 메서드는 사용자로부터 16 진수 입력을 가져와 Decimal 출력으로 변환합니다.

    public static void main(String args[])
    {
        String hexa_Input;
        int dec_output;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Hexadecimal Number : ");
        hexa_Input = scan.nextLine();

        // 16 진수를 10 진수로 변환합니다.

        dec_output = getHexaToDec(hexa_Input);
      / *
???????? 문자열을 getHexaToDec 함수에 전달하십시오.
???????? dec_output 변수에 10 진수 형식을 리턴합니다.
????? * /
        System.out.println("Number in Decimal: "+dec_output);


    }
}
