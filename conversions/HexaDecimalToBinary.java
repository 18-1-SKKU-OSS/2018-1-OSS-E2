import java.lang.StringBuilder;
import java.util.*;
import java.util.Scanner;
import javax.swing.*;

public class HexaDecimalToBinary {
 
    private final int LONG_BITS = 8;

    public void convert(String numHex) {
     
        int conHex = Integer.parseInt(numHex, 16);
        String binary = Integer.toBinaryString(conHex);
       
        System.out.println(numHex + " = " + completeDigits(binary));
    }

    public String completeDigits(String binNum) {
        for (int i = binNum.length(); i < LONG_BITS; i++) {
            binNum = "0" + binNum;
        }
        return binNum;
    }

    public static void main(String[] args) {

        //�׽�Ʈ ����
        String[] hexNums = {"1", "A1", "ef", "BA", "AA", "BB",
            "19", "01", "02", "03", "04"};
        HexaDecimalToBinary objConvert = new HexaDecimalToBinary();

        for (String num : hexNums) {
            objConvert.convert(num);
        }
    }
}