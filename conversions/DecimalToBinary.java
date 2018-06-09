import java.util.Scanner;

/**
 * 이 클래스는 10 진수를 2 진수로 변환합니다.
 * 
 * @author Unknown
 *
 */
class DecimalToBinary {

    /**
     * 메인 메소드
     * 
     */
    public static void main(String args[]) {
        conventionalConversion();
        bitwiseConversion();
    }

    /**
     *이 방법은 기존 알고리즘을 사용하여 10 진수를 2 진수로 변환합니다.
     */
    public static void conventionalConversion() {
        int n, b = 0, c = 0, d;
        Scanner input = new Scanner(System.in);
        System.out.printf("Conventional conversion.\n\tEnter the decimal number: ");
        n = input.nextInt();
        while (n != 0) {
            d = n % 2;
            b = b + d * (int) Math.pow(10, c++);
            n /= 2;
        } //converting decimal to binary
        System.out.println("\tBinary number: " + b);
    }

    /**
     *이 방법은 기존 알고리즘을 사용하여 10 진수를 2 진수로 변환합니다.
     */
    public static void bitwiseConversion() {
        int n, b = 0, c = 0, d;
        Scanner input = new Scanner(System.in);
        System.out.printf("Bitwise conversion.\n\tEnter the decimal number: ");
        n = input.nextInt();
        while (n != 0) {
            d = (n & 1);
            b += d * (int) Math.pow(10, c++);
            n >>= 1;
        }
        System.out.println("\tBinary number: " + b);
    }

}
