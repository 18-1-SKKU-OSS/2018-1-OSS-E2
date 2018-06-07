/*
This program will return all the subsequences of the input string in a string array;
이 프로그램은 문자열의 부분열을 문자열의 배열 형태로 리턴합니다. 

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
    * 메인 메서드는 문자열을 입력받고 부분 문자열을 리턴하는 메서드를 실행합니다. 
    * */
    public static void main(String[] args) {
        System.out.println("Enter String: ");
        Scanner s=new Scanner(System.in);
        String givenString=s.nextLine(); //given string  주어진 문자열
        String[] subsequence=returnSubsequence(givenString); //calling returnSubsequence() function		returnSubsequence() 함수 호출
        System.out.println("Subsequences : ");
        for(int i=0;i<subsequence.length;i++) //print the given array of subsequences	부분 문자열의 배열을 출력합니다. 
        {
            System.out.println(subsequence[i]);
        }
    }
     /**
     * Recursive function to return Subsequences
     * 부분 문자열을 출력하기 위한 재귀함수입니다. 
     */
    private static String[] returnSubsequence(String givenString) {
        if(givenString.length()==0) // If string is empty we will create an array of size=1 and insert "" (Empty string) in it
        							// 만일 문자열이 비어있다면, 크기아 1인 배열을 만들고 ""(빈 문자열) 을 넣을 것입니다. 
        {
           String[] ans=new String[1];
           ans[0]="";
           return  ans;

        }
        String[] SmallAns=returnSubsequence(givenString.substring(1)); //recursive call to get subsequences of substring starting from index position=1
       //부분 문자열의 부분 문자열을 얻기 위한 재귀적 호출입니다. 인덱스 1의 부분 문자열부터 시작합니다. subString 함수는 문자열을 인덱스 기준으로 잘라줍니다. 
        				
        String[] ans=new String[2*SmallAns.length];// Our answer will be an array off string of size=2*SmallAns
        										   // 우리의 답은 SmallAns*2를 크기로 가지는 문자열의 배열일 것입니다. 
        
        for (int i=0;i<SmallAns.length;i++)
        {
            ans[i]=SmallAns[i]; //Copying all the strings present in SmallAns to ans string array  SmallAns에 있는 문자열들은 ans 문자열 배열로 복사합니다. 
        }
        for (int k=0;k<SmallAns.length;k++)
        {
            ans[k+SmallAns.length]=givenString.charAt(0)+SmallAns[k]; // Insert character at index=0 of the given substring in front of every string in SmallAns
        }															  // SmallAns의 모든 문자열 안에 주어진 부분 문자열의 0번째 인덱스에 있는 문자를 삽입합니다. 
        return ans;
    }
}
