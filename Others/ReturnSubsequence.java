/*
This program will return all the subsequences of the input string in a string array;
�� ���α׷��� ���ڿ��� �κп��� ���ڿ��� �迭 ���·� �����մϴ�. 

Sample Input:
abc
Sample Output:
"" ( Empty String )
c
b
bc
a
ac
ab
abc

 */

import java.util.Scanner;

public class ReturnSubsequence {
    /**
    * Main function will accept the given string and implement return subsequences function
    * ���� �޼���� ���ڿ��� �Է¹ް� �κ� ���ڿ��� �����ϴ� �޼��带 �����մϴ�. 
    * */
    public static void main(String[] args) {
        System.out.println("Enter String: ");
        Scanner s=new Scanner(System.in);
        String givenString=s.nextLine(); //given string  �־��� ���ڿ�
        String[] subsequence=returnSubsequence(givenString); //calling returnSubsequence() function		returnSubsequence() �Լ� ȣ��
        System.out.println("Subsequences : ");
        for(int i=0;i<subsequence.length;i++) //print the given array of subsequences	�κ� ���ڿ��� �迭�� ����մϴ�. 
        {
            System.out.println(subsequence[i]);
        }
    }
     /**
     * Recursive function to return Subsequences
     * �κ� ���ڿ��� ����ϱ� ���� ����Լ��Դϴ�. 
     */
    private static String[] returnSubsequence(String givenString) {
        if(givenString.length()==0) // If string is empty we will create an array of size=1 and insert "" (Empty string) in it
        							// ���� ���ڿ��� ����ִٸ�, ũ��� 1�� �迭�� ����� ""(�� ���ڿ�) �� ���� ���Դϴ�. 
        {
           String[] ans=new String[1];
           ans[0]="";
           return  ans;

        }
        String[] SmallAns=returnSubsequence(givenString.substring(1)); //recursive call to get subsequences of substring starting from index position=1
       //�κ� ���ڿ��� �κ� ���ڿ��� ��� ���� ����� ȣ���Դϴ�. �ε��� 1�� �κ� ���ڿ����� �����մϴ�. subString �Լ��� ���ڿ��� �ε��� �������� �߶��ݴϴ�. 
        				
        String[] ans=new String[2*SmallAns.length];// Our answer will be an array off string of size=2*SmallAns
        										   // �츮�� ���� SmallAns*2�� ũ��� ������ ���ڿ��� �迭�� ���Դϴ�. 
        
        for (int i=0;i<SmallAns.length;i++)
        {
            ans[i]=SmallAns[i]; //Copying all the strings present in SmallAns to ans string array  SmallAns�� �ִ� ���ڿ����� ans ���ڿ� �迭�� �����մϴ�. 
        }
        for (int k=0;k<SmallAns.length;k++)
        {
            ans[k+SmallAns.length]=givenString.charAt(0)+SmallAns[k]; // Insert character at index=0 of the given substring in front of every string in SmallAns
        }															  // SmallAns�� ��� ���ڿ� �ȿ� �־��� �κ� ���ڿ��� 0��° �ε����� �ִ� ���ڸ� �����մϴ�. 
        return ans;
    }
}
