import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 *
 */

public class AnyBaseToDecimal {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String inp = br.readLine();
        int base =  Integer.parseInt(br.readLine());

        System.out.println("Input in base " + base + " is: " + inp);
        System.out.println("Decimal value of " + inp + " is: " + convertToDecimal(inp, base));

        br.close();
    }

     /*
       *�� �޼ҵ�� ��� �⺻ �Է��� 10 ���� ���� �����մϴ�.
       * @param inp_num 10 ���� ���� ���� ������ �⺻ ���ڿ��� �ʿ��մϴ�.
       * @return 10 ������ ���ڿ� ����
     */

    public static String convertToDecimal(String inp_num, int base) {
        int len = inp_num.length();
        int num = 0;
        int pow = 1;

        for (int i = len-1; i >= 0; i--) {
            if (valOfChar(inp_num.charAt(i)) >= base) {
                return "Invalid Number";
            }
            num += valOfChar(inp_num.charAt(i))*pow;
            pow *= base;
        }
        return String.valueOf(num);
    }

    /**
      * �� �޼���� �Է� ������ ���� ���� �����ϰ� �̸� ��ȯ�մϴ�.
      * @param c �������� ���� �ʿ���ϴ� Char
      * @return ���� ��
     */

    public static int valOfChar(char c) {
        if (c >= '0' && c <= '9') {
            return (int)c - '0';
        }
        else {
            return (int)c - 'A' + 10;
        }
    }
}
