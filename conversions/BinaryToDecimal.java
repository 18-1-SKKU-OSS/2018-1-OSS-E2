import java.util.Scanner;

/**
 * �� Ŭ������ �������� 10 ������ ��ȯ�մϴ�.
 * 
 * @author Unknown
 *
 */
class BinaryToDecimal
{
  /* ���� �޼ҵ�*/
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int BinaryNum, k, d, DecimalNum = 0, c = 0;
    System.out.print("Binary number: ");
    BinaryNum = sc.nextInt();
    k = BinaryNum;
    while(k != 0)
    {
      d = k%10;
      DecimalNum += d*(int)Math.pow(2,c++);
      k /= 10;
    }
    System.out.println("Decimal equivalent:"+DecimalNum);
    sc.close();
  }
}
