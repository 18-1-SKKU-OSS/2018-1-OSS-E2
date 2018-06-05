import java.util.Scanner;


/**
 * @author Kyler Smith, 2017
 *
 * Implementation of a character count.
 * (Slow, could be improved upon, effectively O(n).
 * 
 * 문자의 갯수를 셉니다. 
 * 시간복잡도 O(n) 을 가집니다. 
 * 
 * */

public class CountChar {

    public static void main(String[] args) {
  	  	Scanner input = new Scanner(System.in);
  	  	System.out.print("Enter your text: ");
      	String str = input.nextLine();
        input.close();
        System.out.println("There are " + CountCharacters(str) + " characters.");
    }
	
    /**
     * @param str: String to count the characters
     *
     * @return int: Number of characters in the passed string
     * 
     * str이라는 변수는 문자를 셀 문자열입니다. 
     * 문자열에 있는 문자의 수를 리턴합니다. 
     * */

    private static int CountCharacters(String str) {

    	int count = 0;

    	if(str == "" || str == null) //Exceptions 예외 
		{ 
			return 0; 
		}

        for(int i = 0; i < str.length(); i++) {
        	if(!Character.isWhitespace(str.charAt(i))) {
        		count++;
			}}

        return count;
     }
}
