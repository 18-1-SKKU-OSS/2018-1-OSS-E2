package Conversions;

import java.util.Scanner;

public class HexaDecimalToDecimal {

    // 16 ������ 10 ������ ��ȯ�մϴ�.
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

   // Main �޼���� ����ڷκ��� 16 ���� �Է��� ������ Decimal ������� ��ȯ�մϴ�.

    public static void main(String args[])
    {
        String hexa_Input;
        int dec_output;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Hexadecimal Number : ");
        hexa_Input = scan.nextLine();

        // 16 ������ 10 ������ ��ȯ�մϴ�.

        dec_output = getHexaToDec(hexa_Input);
      / *
???????? ���ڿ��� getHexaToDec �Լ��� �����Ͻʽÿ�.
???????? dec_output ������ 10 ���� ������ �����մϴ�.
????? * /
        System.out.println("Number in Decimal: "+dec_output);


    }
}
