import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This method produces a reversed version of a string
 * 이 메서드는 문자열을 거꾸로 뒤집어줍니다. 
 * 
 * @author Unknown
 *
 */
class ReverseString
{
	
	/**
	 * This method reverses the string str and returns it
	 * @param str String to be reversed
	 * @return Reversed string
	 * 
	 * 이 메서드는 문자열 str을 뒤집고 뒤집은 문자열을 리턴합니다. 
	 * str이라는 변수는 뒤집을 문자열입니다. 
	 * 뒤집어진 문자열을 리턴합니다.
	 * 
	 */
	public static String reverse(String str){
          if(str.isEmpty() || str == null) return str;
          
          char arr[] = str.toCharArray();
          for(int i = 0, j = str.length() - 1; i < j; i++, j--){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
          }
          return new String(arr);
        }
	
	/**
	 * Main Method
	 * 메인 메서드
	 * 
	 * @param args Command line arguments
	 * @throws IOException Exception thrown because of BufferedReader
	 * 
	 * args 변수는 명령줄 인수입니다. 
	 * IOException 예외가 BufferedReader 사용으로 인해 던져집니다. 
	 * 
	 */
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the string");
		String srr=br.readLine();
		System.out.println("Reverse="+reverse(srr));
		br.close();
	}
}
		
