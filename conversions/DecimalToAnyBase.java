import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 *
 */

public class DecimalToAnyBase {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the decimal input below: ");
        int decInput = Integer.parseInt(br.readLine());
        System.out.println();

        System.out.println("Enter the base below: ");
        int base =  Integer.parseInt(br.readLine());
        System.out.println();

        System.out.println("Decimal Input" + " is: " + decInput);
        System.out.println("Value of " + decInput + " in base " + base + " is: " + convertToAnyBase(decInput, base));

        br.close();
    }

    /**
      *�� �޼ҵ�� ��� �Է� �������� String ���� ��� �ٸ� �������� �����մϴ�.
????? * @param inp 10 ������ base���� String �������� �� �ʿ�
????? * @return �־��� �⺻���� ��ȯ �� ���� ���ڿ� ����
     */

    public static String convertToAnyBase(int inp, int base) {
        ArrayList<Character> charArr = new ArrayList<>();

        while (inp > 0) {
            charArr.add(reVal(inp%base));
            inp /= base;
        }

        StringBuilder str = new StringBuilder(charArr.size());

        for(Character ch: charArr)
        {
            str.append(ch);
        }

        return str.reverse().toString();
    }

    /**
    *�� �޼���� �Է� ������ ���� ���� �����ϰ� �̸� ��ȯ�մϴ�.
???? * @param num ĳ������ ���� �ʿ��� ����.
?????* @return ���� ��
     */

    public static char reVal(int num) {
        if (num >= 0 && num <= 9)
            return (char)(num + '0');
        else
            return (char)(num - 10 + 'A');
    }
}
