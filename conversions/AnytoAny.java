package Java.Conversions;

import java.util.Scanner;
// 소스 번호, 소스 코드, 대상 코드를 지정하면이 코드가 목적지 번호를 제공 할 수 있습니다.
// sn, sb, db ---> () dn. 이것이 우리가해야 할 일입니다.

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
