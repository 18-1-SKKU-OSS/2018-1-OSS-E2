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
       *이 메소드는 모든 기본 입력의 10 진수 값을 생성합니다.
       * @param inp_num 10 진수 값과 정수 형식의 기본 문자열이 필요합니다.
       * @return 10 진수의 문자열 형식
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
      * 이 메서드는 입력 문자의 정수 값을 생성하고 이를 반환합니다.
      * @param c 정수형의 값을 필요로하는 Char
      * @return 정수 값
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
