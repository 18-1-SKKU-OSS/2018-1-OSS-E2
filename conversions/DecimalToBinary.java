import java.util.Scanner;

/**
 * �� Ŭ������ 10 ������ 2 ������ ��ȯ�մϴ�.
 * 
 * @author Unknown
 *
 */
class DecimalToBinary {

    /**
     * ���� �޼ҵ�
     * 
     */
    public static void main(String args[]) {
        conventionalConversion();
        bitwiseConversion();
    }

    /**
     *�� ����� ���� �˰����� ����Ͽ� 10 ������ 2 ������ ��ȯ�մϴ�.
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
     *�� ����� ���� �˰����� ����Ͽ� 10 ������ 2 ������ ��ȯ�մϴ�.
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
