package Java.Conversions;

import java.util.Scanner;
// �ҽ� ��ȣ, �ҽ� �ڵ�, ��� �ڵ带 �����ϸ��� �ڵ尡 ������ ��ȣ�� ���� �� �� �ֽ��ϴ�.
// sn, sb, db ---> () dn. �̰��� �츮���ؾ� �� ���Դϴ�.

public class AnytoAny {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int sn = scn.nextInt();
        int sb = scn.nextInt();
        int db = scn.nextInt();
        int m = 1, dec = 0, dn = 0;
        while (sn != 0) {
            dec = dec + (sn % 10) * m;
            m *= sb;
            sn /= 10;
        }
        m = 1;
        while (dec != 0) {
            dn = dn + (dec % db) * m;
            m *= 10;
            dec /= db;
        }
        System.out.println(dn);
    }

}
