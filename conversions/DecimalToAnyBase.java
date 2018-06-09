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
      *이 메소드는 모든 입력 십진수의 String 값을 어떠한 다른 기준으로 생성합니다.
????? * @param inp 10 진수로 base에서 String 형식으로 값 필요
????? * @return 주어진 기본에서 변환 된 값의 문자열 형식
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
    *이 메서드는 입력 정수의 문자 값을 생성하고 이를 반환합니다.
???? * @param num 캐릭터의 값이 필요한 정수.
?????* @return 문자 값
     */

    public static char reVal(int num) {
        if (num >= 0 && num <= 9)
            return (char)(num + '0');
        else
            return (char)(num - 10 + 'A');
    }
}
