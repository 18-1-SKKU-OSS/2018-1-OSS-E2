import java.util.Scanner;

/**
 * 이 클래스는 10 진수를 8 진수로 변환합니다.
 * 
 * @author Unknown
 *
 */
class Decimal_Octal
{
	/**
	 * 메인 메소드
	 */
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    int n, k, d, s = 0, c = 0;
    System.out.print("Decimal number: ");
    n = sc.nextInt();
    k = n;
    while(k ! = 0)
    {
      d = k % 8;
      s += d*(int)Math.pow(10, c++);
      k /= 8;
    }
   
    System.out.println("Octal equivalent:"+s);
    sc.close();
  }
}
